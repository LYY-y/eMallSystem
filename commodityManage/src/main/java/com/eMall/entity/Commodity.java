package com.eMall.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//商品实体类
@Component("commodity")
public class Commodity implements Serializable {
    //商品编号
    private String com_id;
    //折扣编号
    private String discount_id;
    //商品种类编号
    private String ca_id;
    //商品运费信息
    private String fe_id;
    //商品名称
    private String com_name;
    //商品价格
    private BigDecimal com_price;
    //商品状态
    private String com_state;
    //商品库存
    private String com_stock;
    //商品重量
    private double com_weight;
    //商品产地
    private String com_place;
    //商品上架时间
    private Date inDate;
    //商品下架时间
    private Date outDate;
    //商品折后价
    private BigDecimal discounted_price;

    public Commodity() {
    }

    public Commodity(String com_id, String discount_id, String ca_id, String fe_id, String com_name, BigDecimal com_price, String com_state, String com_stock, double com_weight, String com_place, Date inDate, Date outDate, BigDecimal discounted_price) {
        this.com_id = com_id;
        this.discount_id = discount_id;
        this.ca_id = ca_id;
        this.fe_id = fe_id;
        this.com_name = com_name;
        this.com_price = com_price;
        this.com_state = com_state;
        this.com_stock = com_stock;
        this.com_weight = com_weight;
        this.com_place = com_place;
        this.inDate = inDate;
        this.outDate = outDate;
        this.discounted_price = discounted_price;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "com_id='" + com_id + '\'' +
                ", discount_id='" + discount_id + '\'' +
                ", ca_id='" + ca_id + '\'' +
                ", fe_id='" + fe_id + '\'' +
                ", com_name='" + com_name + '\'' +
                ", com_price=" + com_price +
                ", com_state='" + com_state + '\'' +
                ", com_stock='" + com_stock + '\'' +
                ", com_weight=" + com_weight +
                ", com_place='" + com_place + '\'' +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                ", discounted_price=" + discounted_price +
                '}';
    }

    public String getCom_id() {
        return com_id;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public String getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(String discount_id) {
        this.discount_id = discount_id;
    }

    public String getCa_id() {
        return ca_id;
    }

    public void setCa_id(String ca_id) {
        this.ca_id = ca_id;
    }

    public String getFe_id() {
        return fe_id;
    }

    public void setFe_id(String fe_id) {
        this.fe_id = fe_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public BigDecimal getCom_price() {
        return com_price;
    }

    public void setCom_price(BigDecimal com_price) {
        this.com_price = com_price;
    }

    public String getCom_state() {
        return com_state;
    }

    public void setCom_state(String com_state) {
        this.com_state = com_state;
    }

    public String getCom_stock() {
        return com_stock;
    }

    public void setCom_stock(String com_stock) {
        this.com_stock = com_stock;
    }

    public double getCom_weight() {
        return com_weight;
    }

    public void setCom_weight(double com_weight) {
        this.com_weight = com_weight;
    }

    public String getCom_place() {
        return com_place;
    }

    public void setCom_place(String com_place) {
        this.com_place = com_place;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public BigDecimal getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(BigDecimal discounted_price) {
        this.discounted_price = discounted_price;
    }
}
