package com.trifail.order.databean.v1;

import io.swagger.annotations.ApiModelProperty;

public class V1OrderInfo {

    @ApiModelProperty(notes = "商品列表")
    private String goods;
    @ApiModelProperty(notes = "顾客信息", position = 1)
    private String customer_info;

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getCustomer_info() {
        return customer_info;
    }

    public void setCustomer_info(String customer_info) {
        this.customer_info = customer_info;
    }
}
