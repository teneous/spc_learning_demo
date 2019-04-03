package com.trifail.basis.core;

import org.apache.logging.log4j.util.PropertiesUtil;

public class ErrorCode {

    /*500*/
    private String status;
    /*INVALID_ORDER_NO*/
    private String code;
    /*无效订单*/
    private String message;

    public ErrorCode(String status, String code, String message) {
        this.status = status;
        this.code = code;

        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
