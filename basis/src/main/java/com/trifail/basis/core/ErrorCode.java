package com.trifail.basis.core;


public class ErrorCode {

    private String code;
    private String error_message;

    public ErrorCode(String code, String message) {
        this.code = code;
        this.error_message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
