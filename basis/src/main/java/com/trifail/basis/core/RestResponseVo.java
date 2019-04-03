package com.trifail.basis.core;

import com.trifail.basis.util.PropertyUtil;
import org.springframework.http.HttpStatus;

public class RestResponseVo<T> {

    private T result;
    private HttpStatus status_code;
    private ErrorCode error_code;
    private String return_msg;

    public RestResponseVo(T result) {
        this(result,HttpStatus.OK,"success");
    }

    public RestResponseVo(ErrorCode error_code) {
        this.error_code = error_code;
//        this.return_msg = PropertyUtil.error_code.getMessage();
    }

    public RestResponseVo(T result,HttpStatus status_code, String return_msg) {
        this.result = result;
        this.status_code = status_code;
        this.return_msg = return_msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public HttpStatus getStatus_code() {
        return status_code;
    }

    public void setStatus_code(HttpStatus status_code) {
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
