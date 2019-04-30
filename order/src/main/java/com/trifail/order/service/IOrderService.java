package com.trifail.order.service;

import com.trifail.basis.common.CommonIdVo;
import com.trifail.basis.core.RestPageRequestVo;
import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.databean.CustomerOrderInfo;
import com.trifail.order.databean.v1.V1OrderInfo;

import java.util.List;

/**
 * Created by syoka on 2019/3/11.
 */
public interface IOrderService {

    /**
     * 创建订单
     * @return 返回订单号
     */
    RestResponseVo createOrder(V1OrderInfo orderInfo);


    /**
     * 获取顾客订单
     * find specific order of the customer
     * @return 返回顾客订单基础信息
     */
    RestResponseVo<List<CustomerOrderInfo>> getCustomerOrderList(RestPageRequestVo<CommonIdVo> cInfo);


    /**
     * 订单撤销,仅仅是尚未发货的订单可撤销
     */
    RestResponseVo rollback(String serialno);

}
