package com.trifail.basis.api.databean;

import java.math.BigDecimal;

public class V1PaymentInfo {

    private String paytype;
    private BigDecimal paymoney;

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }
}
