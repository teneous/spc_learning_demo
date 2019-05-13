package com.trifail.protocol.core;

import java.io.Serializable;

public class RestPageRequestVo<T> implements Serializable {
    private int current_page = 1;
    private int page_size = 15;
    private T search_field;
    private String order_field = "id";
    private String order_type = "desc";

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public T getSearch_field() {
        return search_field;
    }

    public void setSearch_field(T search_field) {
        this.search_field = search_field;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public String getOrder_field() {
        return order_field;
    }

    public void setOrder_field(String order_field) {
        this.order_field = order_field;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }
}
