package model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 订单主信息
 */
public class V1OrderInfo {

    @ApiModelProperty(notes = "商品列表")
    private List<V1OrderGoodsInfo> goods;

    @ApiModelProperty(notes = "顾客信息", position = 1)
    private String cid;

    @ApiModelProperty(notes = "收货人信息", position = 2)
    private V1OrderReceiverInfo receiver;

    @ApiModelProperty(notes = "支付信息", position = 3)
    private List<V1PaymentInfo> payMoney;

    public List<V1OrderGoodsInfo> getGoods() {
        return goods;
    }

    public void setGoods(List<V1OrderGoodsInfo> goods) {
        this.goods = goods;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public V1OrderReceiverInfo getReceiver() {
        return receiver;
    }

    public void setReceiver(V1OrderReceiverInfo receiver) {
        this.receiver = receiver;
    }

    public List<V1PaymentInfo> getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(List<V1PaymentInfo> payMoney) {
        this.payMoney = payMoney;
    }
}
