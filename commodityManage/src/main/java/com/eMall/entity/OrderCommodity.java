package com.eMall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderCommodity implements Serializable {
    @JsonSerialize(using= ToStringSerializer.class)
    private long order_id;
    @JsonSerialize(using= ToStringSerializer.class)
    private long cid;

    private int num;
    private BigDecimal single_price;
    private BigDecimal total_price;

    public OrderCommodity() {
    }

    public OrderCommodity(long order_id, long cid, int num, BigDecimal single_price, BigDecimal total_price) {
        this.order_id = order_id;
        this.cid = cid;
        this.num = num;
        this.single_price = single_price;
        this.total_price = total_price;
    }

    @JsonProperty
    public String getOrder_id() {
        return String.valueOf(order_id);
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
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

    public BigDecimal getSingle_price() {
        return single_price;
    }

    public void setSingle_price(BigDecimal single_price) {
        this.single_price = single_price;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "OrderCommodity{" +
                "order_id=" + order_id +
                ", cid=" + cid +
                ", num=" + num +
                ", single_price=" + single_price +
                ", total_price=" + total_price +
                '}';
    }
}
