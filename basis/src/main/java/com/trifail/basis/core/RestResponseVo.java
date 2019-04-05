package com.trifail.basis.core;

import org.springframework.http.HttpStatus;

public class RestResponseVo<T> {

    private String api_version = "1.0";
    private T result;
    private int status_code;
    private ErrorCode error_code;
    private String return_msg;

    public RestResponseVo(T result) {
        this(result,HttpStatus.OK.value(),"success");
    }

    public RestResponseVo(ErrorCode error_code) {
        this.error_code = error_code;
        status_code = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public RestResponseVo(T result,int status_code, String return_msg) {
        this.result = result;
        this.status_code = status_code;
        this.return_msg = return_msg;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ErrorCode getError_code() {
        return error_code;
    }

    public void setError_code(ErrorCode error_code) {
        this.error_code = error_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
}
