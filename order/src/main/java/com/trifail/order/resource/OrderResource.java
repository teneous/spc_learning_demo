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
@RequestMapping("/order/v1")
public class OrderResource{

    private final IOrderService orderService;

    @Autowired
    public OrderResource(IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 获取某个顾客的订单记录
     */
    @ApiOperation(value = "find specific orders of the customer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 500, message = "System error")
    })
    @PostMapping("/customer")
    public RestResponseVo<List<CustomerOrderInfo>> getCustomerOrders(
            @ApiParam(value = "customer unique id", required = true) @RequestBody RestRequestVo<RestPageRequestVo<CommonIdVo>> cInfo){
        return orderService.getCustomerOrderList(cInfo.getRequest_data());
    }

    /**
     * 生成订单
     */
    @ApiOperation(value = "generate a order", response = String.class)
    @PostMapping("/")
    public RestResponseVo createOrder(@RequestBody RestRequestVo<V1OrderInfo> orderInfo){
        return orderService.createOrder(orderInfo.getRequest_data());
    }

    /**
     * 订单回滚
     */
    @ApiOperation(value = "cancel the order", response = String.class)
    @DeleteMapping("/rollback/{serialno}")
    public RestResponseVo rollbackOrder(@PathVariable String serialno){
        return new RestResponseVo(OrderErrorcode.ORDER_NOT_EXISTS);
   }

}
