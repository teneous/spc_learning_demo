package com.trifail.protocol.core;

public class RestRequestVo<T> {

    private T request_data;

    public T getRequest_data() {
        return request_data;
    }

    public void setRequest_data(T request_data) {
        this.request_data = request_data;
    }
}
