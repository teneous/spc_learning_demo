package com.trifail.stock.common;

import com.trifail.protocol.core.ErrorCode;

public class StockErrorCode extends ErrorCode {
    

    public StockErrorCode(String code, String message) {
        super(code, message);
    }

    public static StockErrorCode GOODS_NOT_EXISTS = new StockErrorCode("01[GOODSNOT_EXISTS]","stock.error.goods.not.exists");

}
