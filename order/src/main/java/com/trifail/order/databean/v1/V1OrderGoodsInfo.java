package com.trifail.order.databean.v1;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 商品
 */
public class V1OrderGoodsInfo {

    @ApiModelProperty(notes = "商品名")
    private String goods_name;
    @ApiModelProperty(notes = "商品唯一标识No")
    private String goods_no;
    @ApiModelProperty(notes = "商品价格")
    private BigDecimal price;
    @ApiModelProperty(notes = "商品数量")
    private int number;

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_no() {
        return goods_no;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
