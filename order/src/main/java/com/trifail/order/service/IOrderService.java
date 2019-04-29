package com.trifail.order.service;

import com.trifail.basis.common.CommonIdVo;
import com.trifail.basis.core.RestPageRequestVo;
import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.databean.CustomerOrderInfo;
import com.trifail.order.databean.OrderInfo;

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
     * create a order
     * @return 返回订单号
     */
    RestResponseVo<List<CustomerOrderInfo>> getCustomerOrderList(RestPageRequestVo<CommonIdVo> cInfo);


    /**
     * 订单撤销,仅仅是尚未发货的订单可撤销
     */
    RestResponseVo rollback(String serialno);

}
