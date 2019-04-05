package com.trifail.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by syoka on 2019/3/12.
 */
@Entity
@Table(name = "orders", indexes = {@Index(name = "idx_serial", columnList = "serial_no"),
        @Index(name = "idx_cid", columnList = "customer_id")})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "serial_no", length = 20, nullable = false)
    private String serialNo;
    @Column(name = "customer_id", length = 20, nullable = false)
    private Long customerId;
    @Column(name = "create_time", nullable = false)
    private LocalDate createTime;
    @Column(name = "update_time", nullable = false)
    private LocalDate updateTime;
    /*代付款，待收货，完成，取消*/
    @Column(name = "type", length = 6, nullable = false)
    private Short type;
    @Column(name = "order_money", length = 11, nullable = false)
    private BigDecimal orderMoney;
    @Column(name = "real_pay_money", length = 11, nullable = false)
    private BigDecimal realPayMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public BigDecimal getRealPayMoney() {
        return realPayMoney;
    }

    public void setRealPayMoney(BigDecimal realPayMoney) {
        this.realPayMoney = realPayMoney;
    }
}
