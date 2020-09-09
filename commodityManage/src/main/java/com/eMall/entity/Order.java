package com.eMall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order implements Serializable {
    @JsonSerialize(using= ToStringSerializer.class)
    private long order_id;
    @JsonSerialize(using= ToStringSerializer.class)
    private long buyer_id;
    @JsonSerialize(using= ToStringSerializer.class)
    private long shop_id;

    private String from_place;
    private String dest_place;
    private Timestamp order_time;
    private String receiver_name;
    private String receiver_phone;
    private int order_state;
    private int pay_method;
    private BigDecimal freight;
    private BigDecimal all_price;
    private BigDecimal real_pay;

    public Order() {
    }

    public Order(long order_id, long buyer_id, long shop_id, String from_place, String dest_place, Timestamp order_time,
                 String receiver_name, String receiver_phone, int order_state, int pay_method, BigDecimal freight,
                 BigDecimal all_price, BigDecimal real_pay) {
        this.order_id = order_id;
        this.buyer_id = buyer_id;
        this.shop_id = shop_id;
        this.from_place = from_place;
        this.dest_place = dest_place;
        this.order_time = order_time;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.order_state = order_state;
        this.pay_method = pay_method;
        this.freight = freight;
        this.all_price = all_price;
        this.real_pay = real_pay;
    }

    @JsonProperty
    public String getOrder_id() {
        return String.valueOf(order_id);
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
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

    public String getFrom_place() {
        return from_place;
    }

    public void setFrom_place(String from_place) {
        this.from_place = from_place;
    }

    public String getDest_place() {
        return dest_place;
    }

    public void setDest_place(String dest_place) {
        this.dest_place = dest_place;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public int getPay_method() {
        return pay_method;
    }

    public void setPay_method(int pay_method) {
        this.pay_method = pay_method;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
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

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", buyer_id=" + buyer_id +
                ", shop_id=" + shop_id +
                ", from_place='" + from_place + '\'' +
                ", dest_place='" + dest_place + '\'' +
                ", order_time=" + order_time +
                ", receiver_name='" + receiver_name + '\'' +
                ", receiver_phone='" + receiver_phone + '\'' +
                ", order_state=" + order_state +
                ", pay_method=" + pay_method +
                ", freight=" + freight +
                ", all_price=" + all_price +
                ", real_pay=" + real_pay +
                '}';
    }
}
