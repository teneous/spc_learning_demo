package com.trifail.order.resource;

import com.trifail.basis.common.CommonIdVo;
import com.trifail.basis.core.RestPageRequestVo;
import com.trifail.basis.core.RestRequestVo;
import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.common.OrderErrorcode;
import com.trifail.order.databean.CustomerOrderInfo;
import com.trifail.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by syoka on 2019/3/12.
 */
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
     * find specific order of the customer
     * @param cInfo 顾客id信息
     */
    @PostMapping("/customer")
    public RestResponseVo<List<CustomerOrderInfo>> getCustomerOrders(@RequestBody RestRequestVo<RestPageRequestVo<CommonIdVo>> cInfo){
        return orderService.getCustomerOrderList(cInfo.getRequest_data());
    }

    /**
     * 订单回滚
     */
    @DeleteMapping("/rollback/{serialno}")
    public RestResponseVo rollbackOrder(@PathVariable String serialno){
        return new RestResponseVo(OrderErrorcode.ORDER_NOT_EXISTS);
//        orderService.rollback(serialno);
//        return null;
   }

}
