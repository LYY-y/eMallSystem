package com.eMall.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class FreightInfo implements Serializable {
    private long freight_id;
    private String from;
    private String dest;
    private int charge_type;
    private BigDecimal first_weight;
    private BigDecimal first_fee;
    private BigDecimal continue_weight;
    private BigDecimal continue_fee;

    public FreightInfo() {
    }


    public FreightInfo(long freight_id, String from, String dest, int charge_type, BigDecimal first_weight, BigDecimal first_fee, BigDecimal continue_weight, BigDecimal continue_fee) {
        this.freight_id = freight_id;
        this.from = from;
        this.dest = dest;
        this.charge_type = charge_type;
        this.first_weight = first_weight;
        this.first_fee = first_fee;
        this.continue_weight = continue_weight;
        this.continue_fee = continue_fee;
    }

    public long getFreight_id() {
        return freight_id;
    }

    public void setFreight_id(long freight_id) {
        this.freight_id = freight_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getCharge_type() {
        return charge_type;
    }

    public void setCharge_type(int charge_type) {
        this.charge_type = charge_type;
    }

    public BigDecimal getFirst_weight() {
        return first_weight;
    }

    public void setFirst_weight(BigDecimal first_weight) {
        this.first_weight = first_weight;
    }

    public BigDecimal getFirst_fee() {
        return first_fee;
    }

    public void setFirst_fee(BigDecimal first_fee) {
        this.first_fee = first_fee;
    }

    public BigDecimal getContinue_weight() {
        return continue_weight;
    }

    public void setContinue_weight(BigDecimal continue_weight) {
        this.continue_weight = continue_weight;
    }

    public BigDecimal getContinue_fee() {
        return continue_fee;
    }

    public void setContinue_fee(BigDecimal continue_fee) {
        this.continue_fee = continue_fee;
    }

    @Override
    public String toString() {
        return "FreightInfo{" +
                "freight_id=" + freight_id +
                ", from_area='" + from + '\'' +
                ", to_area='" + dest + '\'' +
                ", charge_type=" + charge_type +
                ", first_weight=" + first_weight +
                ", first_fee=" + first_fee +
                ", continue_weight=" + continue_weight +
                ", continue_fee=" + continue_fee +
                '}';
    }
}
