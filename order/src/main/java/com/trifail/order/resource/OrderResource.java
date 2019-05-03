package com.trifail.order.resource;

import com.trifail.basis.common.CommonIdVo;
import com.trifail.basis.core.RestPageRequestVo;
import com.trifail.basis.core.RestRequestVo;
import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.common.OrderErrorcode;
import com.trifail.order.databean.CustomerOrderInfo;
import com.trifail.order.databean.v1.V1OrderInfo;
import com.trifail.order.service.IOrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by syoka on 2019/3/12.
 */
@Api(value = "Order Api")
@RestController
@RequestMapping("/v1")
public class OrderResource{

    private final IOrderService orderService;

    @Autowired
    public OrderResource(IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * find specific orders of the customer
     */
    @ApiOperation(value = "获取某个顾客的订单记录", response = RestResponseVo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 500, message = "System error")
    })
    @PostMapping("/customer/list")
    public RestResponseVo<List<CustomerOrderInfo>> getCustomerOrders(
            @ApiParam(value = "顾客Id", required = true)
            @RequestBody RestRequestVo<RestPageRequestVo<CommonIdVo>> cInfo){
        return orderService.getCustomerOrderList(cInfo.getRequest_data());
    }


    /**
     * 生成订单
     */
    @ApiOperation(value = "创建订单", response = String.class)
    @PostMapping("")
    public RestResponseVo createANewOrder(
            @ApiParam(value = "订单基本详细信息", required = true)@RequestBody RestRequestVo<V1OrderInfo> orderInfo){
        return orderService.createOrder(orderInfo.getRequest_data());
    }

    /**
     * 订单撤销
     */
    @ApiOperation(value = "订单取消")
    @PutMapping("/rollback/{serialno}")
    public RestResponseVo rollbackOrder(@PathVariable String serialno){
        //如果尚未发货则可以直接撤销
        return new RestResponseVo(OrderErrorcode.ORDER_NOT_EXISTS);
   }

}
