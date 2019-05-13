package model;

import java.util.List;

public class V1GoodWrapper {

    private List<V1OrderGoodsInfo> goods;

    public V1GoodWrapper() {
    }

    public V1GoodWrapper(List<V1OrderGoodsInfo> goods) {
        this.goods = goods;
    }

    public List<V1OrderGoodsInfo> getGoods() {
        return goods;
    }

    public void setGoods(List<V1OrderGoodsInfo> goods) {
        this.goods = goods;
    }
}