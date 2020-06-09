package com.eMall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FreightInfo implements Serializable {
    private BigInteger fe_id;
    private String from_area;
    private String to_area;
    private BigDecimal first_weight;
    private BigDecimal first_fee;
    private BigDecimal continue_weight;
    private BigDecimal continue_fee;

    @Override
    public String toString() {
        return "FreightInfo{" +
                "fe_id=" + fe_id +
                ", from_area='" + from_area + '\'' +
                ", to_area='" + to_area + '\'' +
                ", first_weight=" + first_weight +
                ", first_fee=" + first_fee +
                ", continue_weight=" + continue_weight +
                ", continue_fee=" + continue_fee +
                '}';
    }

    public FreightInfo() {
    }

    public FreightInfo(BigInteger fe_id, String from_area, String to_area, BigDecimal first_weight, BigDecimal first_fee, BigDecimal continue_weight, BigDecimal continue_fee) {
        this.fe_id = fe_id;
        this.from_area = from_area;
        this.to_area = to_area;
        this.first_weight = first_weight;
        this.first_fee = first_fee;
        this.continue_weight = continue_weight;
        this.continue_fee = continue_fee;
    }

    public BigInteger getFe_id() {
        return fe_id;
    }

    public void setFe_id(BigInteger fe_id) {
        this.fe_id = fe_id;
    }

    public String getFrom_area() {
        return from_area;
    }

    public void setFrom_area(String from_area) {
        this.from_area = from_area;
    }

    public String getTo_area() {
        return to_area;
    }

    public void setTo_area(String to_area) {
        this.to_area = to_area;
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
}
