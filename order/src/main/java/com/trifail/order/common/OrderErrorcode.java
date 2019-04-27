package com.trifail.order.common;

import com.trifail.basis.core.ErrorCode;
import com.trifail.order.repository.IOrderRepository;

public class OrderErrorcode extends ErrorCode {

    private static IOrderRepository orderRepository;

    public OrderErrorcode(String code, String message) {
        super(code, message);
    }

    public static OrderErrorcode ORDER_NOT_EXISTS = new OrderErrorcode("AAA","order.error.notexists");
    public static OrderErrorcode ORDER_CANNOT_ROLLBACK = new OrderErrorcode("BBB","order.error.notexists");

}
