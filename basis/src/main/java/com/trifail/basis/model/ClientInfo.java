package com.trifail.basis.model;

public class ClientInfo {

    private String identity;
    private Long shopid;

    public ClientInfo() {
    }

    public ClientInfo(String identity, Long shopid) {
        this.identity = identity;
        this.shopid = shopid;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Long getShopid() {
        return shopid;
    }

    public void setShopid(Long shopid) {
        this.shopid = shopid;
    }
}
