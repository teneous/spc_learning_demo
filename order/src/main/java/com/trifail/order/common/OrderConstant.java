package com.trifail.order.common;

public abstract class OrderConstant {

    public static final Short NEW = 0; //新规
    public static final Short FINISHED = 1; //完成
    public static final Short WAIT_PAID = 2; //等待支付
    public static final Short ROLLBACK = 3; //撤销
    public static final Short WAIT_DELIVER = 4; //等待出库
    public static final Short DELIVERING = 5; //派送中
    public static final Short RECEIVED = 6; //已收货
    public static final Short EXPIRED = 7; //超时过期
}
