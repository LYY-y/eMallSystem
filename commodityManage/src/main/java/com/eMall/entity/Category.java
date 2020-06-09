package com.eMall.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private String ca_id;
    private String ca_name;
    private String ca_description;

    public Category() {
    }

    public Category(String ca_id, String ca_name, String ca_description) {
        this.ca_id = ca_id;
        this.ca_name = ca_name;
        this.ca_description = ca_description;
    }

    public String getCa_id() {
        return ca_id;
    }

    public void setCa_id(String ca_id) {
        this.ca_id = ca_id;
    }

    public String getCa_name() {
        return ca_name;
    }

    public void setCa_name(String ca_name) {
        this.ca_name = ca_name;
    }

    public String getCa_description() {
        return ca_description;
    }

    public void setCa_description(String ca_description) {
        this.ca_description = ca_description;
    }
}
