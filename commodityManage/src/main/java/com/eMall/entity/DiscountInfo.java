package com.eMall.entity;

import java.io.Serializable;
import java.util.Date;

public class DiscountInfo implements Serializable {
    private String discount_id;
    private String discountType;
    private double discount;
    private String reason;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "DiscountInfo{" +
                "discount_id='" + discount_id + '\'' +
                ", discountType='" + discountType + '\'' +
                ", discount=" + discount +
                ", reason='" + reason + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public DiscountInfo() {
    }

    public DiscountInfo(String discount_id, String discountType, double discount, String reason, Date startDate, Date endDate) {
        this.discount_id = discount_id;
        this.discountType = discountType;
        this.discount = discount;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(String discount_id) {
        this.discount_id = discount_id;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
