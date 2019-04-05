package com.trifail.order.databean;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by syoka on 2019/3/12.
 */
public class CustomerOrderInfo implements Serializable {

    private String serioNo;
    private BigDecimal totalMoney;
    private String createTime;

    public String getSerioNo() {
        return serioNo;
    }

    public void setSerioNo(String serioNo) {
        this.serioNo = serioNo;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
