package com.eMall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

public class Buyer {
    @JsonSerialize(using= ToStringSerializer.class)
    private long buyer_id;
    private String buyer_name;
    private String buyer_password;
    private String buyer_phone;
    private int buyer_rating;
    private int buyer_point;

    public Buyer() {
    }

    public Buyer(long buyer_id, String buyer_name, String buyer_password, String buyer_phone, int buyer_rating, int buyer_point) {
        this.buyer_id = buyer_id;
        this.buyer_name = buyer_name;
        this.buyer_password = buyer_password;
        this.buyer_phone = buyer_phone;
        this.buyer_rating = buyer_rating;
        this.buyer_point = buyer_point;
    }

    @JsonProperty
    public String getBuyer_id() {
        return String.valueOf(buyer_id);
    }

    public void setBuyer_id(long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_password() {
        return buyer_password;
    }

    public void setBuyer_password(String buyer_password) {
        this.buyer_password = buyer_password;
    }

    public String getBuyer_phone() {
        return buyer_phone;
    }

    public void setBuyer_phone(String buyer_phone) {
        this.buyer_phone = buyer_phone;
    }

    public int getBuyer_rating() {
        return buyer_rating;
    }

    public void setBuyer_rating(int buyer_rating) {
        this.buyer_rating = buyer_rating;
    }

    public int getBuyer_point() {
        return buyer_point;
    }

    public void setBuyer_point(int buyer_point) {
        this.buyer_point = buyer_point;
    }
}
