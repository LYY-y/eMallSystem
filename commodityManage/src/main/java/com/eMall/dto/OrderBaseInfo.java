package com.eMall.dto;

import com.eMall.entity.Commodity;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderBaseInfo implements Serializable {
    @JsonSerialize(using= ToStringSerializer.class)
    private long order_id;
    @JsonSerialize(using= ToStringSerializer.class)
    private long buyer_id;
    @JsonSerialize(using= ToStringSerializer.class)
    private long shop_id;

    private String from_place;
    private Timestamp order_time;
    private int order_state;
    private BigDecimal all_price;
    private BigDecimal real_pay;

    public OrderBaseInfo() {
    }

    public OrderBaseInfo(long order_id, long buyer_id, long shop_id, String from_place, Timestamp order_time, int order_state, BigDecimal all_price, BigDecimal real_pay) {
        this.order_id = order_id;
        this.buyer_id = buyer_id;
        this.shop_id = shop_id;
        this.from_place = from_place;
        this.order_time = order_time;
        this.order_state = order_state;
        this.all_price = all_price;
        this.real_pay = real_pay;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getFrom_place() {
        return from_place;
    }

    public void setFrom_place(String from_place) {
        this.from_place = from_place;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public BigDecimal getAll_price() {
        return all_price;
    }

    public void setAll_price(BigDecimal all_price) {
        this.all_price = all_price;
    }

    public BigDecimal getReal_pay() {
        return real_pay;
    }

    public void setReal_pay(BigDecimal real_pay) {
        this.real_pay = real_pay;
    }
}
