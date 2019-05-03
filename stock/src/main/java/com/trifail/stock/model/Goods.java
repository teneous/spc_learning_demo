package com.trifail.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    private Long id;
    @Column(name = "product_id", length = 20, nullable = false)
    private String productId;
    @Column(name = "product_name", length = 225, nullable = false)
    private String productName;
    @Column(name = "market_price", length = 11, nullable = false)
    private Integer marketPrice;
    @Column(name = "stock_number", length = 11, nullable = false)
    private Integer stockNumber;
    @Column(name = "remain_number", length = 11, nullable = false)
    private Integer remainNumber;
    @Column(name = "shopid", length = 20, nullable = false)
    private Long shopId;
    @Column(name = "status", length = 20, nullable = false)
    private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getRemainNumber() {
        return remainNumber;
    }

    public void setRemainNumber(Integer remainNumber) {
        this.remainNumber = remainNumber;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
