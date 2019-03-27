package com.trifail.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by syoka on 2019/3/12.
 */
@Entity
@Table(name = "consignee", indexes = {@Index(name = "idx_con_cid", columnList = "customer_id")})
public class Consignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id", length = 20, nullable = false)
    private Long customer_id;
    /*收货人*/
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    /*收货地址*/
    @Column(name = "address", length = 255, nullable = false)
    private String address;
    /*收货人电话*/
    @Column(name = "phoneno", length = 20, nullable = false)
    private String phoneno;
    /*状态*/
    @Column(name = "status", length = 1, nullable = false)
    private boolean status;
    @Column(name = "create_time", nullable = false)
    private LocalDate createTime;
    @Column(name = "update_time")
    private LocalDate updateTime;
    /*顺序番号*/
    @Column(name = "index_no", nullable = false)
    private Integer indexNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate isCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate isUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    public Integer isIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }
}
