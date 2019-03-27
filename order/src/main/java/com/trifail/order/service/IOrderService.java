package com.trifail.order.service;

import com.trifail.order.api.vo.CustomerOrderInfo;
import com.trifail.order.api.vo.OrderInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by syoka on 2019/3/11.
 */
public interface IOrderService {

    /**
     * 创建订单
     * @return 返回订单号
     */
    String createOrder(OrderInfo orderInfo);


    /**
     * 创建订单
     * @return 返回订单号
     */
    List<CustomerOrderInfo> getCustomerOrderList(Long cid);

}
