package com.trifail.stock.common;

import com.trifail.basis.core.ErrorCode;

public class StockErrorcode extends ErrorCode {
    

    public StockErrorcode(String code, String message) {
        super(code, message);
    }

    public static StockErrorcode GOODS_NOT_EXISTS = new StockErrorcode("01[GOODSNOT_EXISTS]","stock.error.goods.not.exists");

}
