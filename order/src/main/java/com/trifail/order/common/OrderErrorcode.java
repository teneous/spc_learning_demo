package com.trifail.order.common;

import com.trifail.basis.core.ErrorCode;
import com.trifail.order.repository.IOrderRepository;

public class OrderErrorcode extends ErrorCode {

    public OrderErrorcode(String code, String message) {
        super(code, message);
    }

    public static OrderErrorcode ORDER_NOT_EXISTS = new OrderErrorcode("01[ORDER_NOT_EXISTS]","order.error.not.exists");
    public static OrderErrorcode ORDER_CANNOT_ROLLBACK = new OrderErrorcode("02[ORDER_CANNOT_ROLLBACK]","order.error.cannot.rollback");
    public static OrderErrorcode ORDER_WITH_NO_PRODUCTS = new OrderErrorcode("03[ORDER_WITH_NO_PRODUCTS]","order.error.with.no.products");

    public static OrderErrorcode ORDER_WITH_RECEIVER_NO_PHONE = new OrderErrorcode("04[ORDER_WITH_RECEIVER_NO_PHONE]","order.error.receiver.no.phone");
    public static OrderErrorcode ORDER_WITH_RECEIVER_NO_ADDR = new OrderErrorcode("05[ORDER_WITH_RECEIVER_NO_ADDR]","order.error.receiver.no.addr");
    public static OrderErrorcode ORDER_WITH_RECEIVER_NO_NAME = new OrderErrorcode("06[ORDER_WITH_RECEIVER_NO_NAME]","order.error.receiver.no.name");

}
