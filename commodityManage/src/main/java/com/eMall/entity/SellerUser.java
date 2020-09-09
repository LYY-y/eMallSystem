package com.eMall.entity;

public class SellerUser extends User {
    //店铺id
    private String shop_id;

    public SellerUser(String name, String password, String shop_id) {
        super(name, password);
        this.shop_id = shop_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }
}
