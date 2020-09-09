package com.eMall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Cart implements Serializable {
    @JsonSerialize(using= ToStringSerializer.class)
    private long buyer_id;
    @JsonSerialize(using= ToStringSerializer.class)
    private long shop_id;
    @JsonSerialize(using= ToStringSerializer.class)
    private long cid;
    private int num;
    private BigDecimal total_price;
    private Timestamp cart_time;
    private int cart_state;

    public Cart(long buyer_id, long shop_id, long cid, int num, BigDecimal total_price, Timestamp cart_time, int cart_state) {
        this.buyer_id = buyer_id;
        this.shop_id = shop_id;
        this.cid = cid;
        this.num = num;
        this.total_price = total_price;
        this.cart_time = cart_time;
        this.cart_state = cart_state;
    }

    public Cart() {
    }

    @JsonProperty
    public String getBuyer_id() {
        return String.valueOf(buyer_id);
    }

    public void setBuyer_id(long buyer_id) {
        this.buyer_id = buyer_id;
    }

    @JsonProperty
    public String getShop_id() {
        return String.valueOf(shop_id);
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    @JsonProperty
    public String getCid() {
        return String.valueOf(cid);
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public Timestamp getCart_time() {
        return cart_time;
    }

    public void setCart_time(Timestamp cart_time) {
        this.cart_time = cart_time;
    }

    public int getCart_state() {
        return cart_state;
    }

    public void setCart_state(int cart_state) {
        this.cart_state = cart_state;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "buy_id=" + buyer_id +
                ", shop_id=" + shop_id +
                ", cid=" + cid +
                ", num=" + num +
                ", total_price=" + total_price +
                ", cart_time=" + cart_time +
                ", cart_state=" + cart_state +
                '}';
    }
}
