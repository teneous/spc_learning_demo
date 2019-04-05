package com.trifail.order.common;

import com.trifail.basis.core.ErrorCode;

public class OrderErrorcode extends ErrorCode {

    public OrderErrorcode(String code, String message) {
        super(code, message);
    }

    public static OrderErrorcode ORDER_NOT_EXISTS = new OrderErrorcode("","");
    public static OrderErrorcode ORDER_CANNOT_ROLLBACK = new OrderErrorcode("","");




}
