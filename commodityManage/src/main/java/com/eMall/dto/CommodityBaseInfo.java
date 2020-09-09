package com.eMall.dto;

public class CommodityBaseInfo {
    private String title;
    private String commodity_id;
    private String brand_id;
    private String category_id;
    private String price;
    private String promotion_price;
    private String description;
    private String stock;
    private String weight;
    private String keywords;
    private String promotion_start_time;
    private String promotion_end_time;
    private String promotion_per_limit;
    private String promotion_type;
    private String place;

    public CommodityBaseInfo() {
    }

    public CommodityBaseInfo(String title, String commodity_id, String brand_id, String category_id, String price,
                             String promotion_price, String description, String stock, String weight, String keywords,
                             String promotion_start_time, String promotion_end_time, String promotion_per_limit,
                             String promotion_type, String place) {
        this.title = title;
        this.commodity_id = commodity_id;
        this.brand_id = brand_id;
        this.category_id = category_id;
        this.price = price;
        this.promotion_price = promotion_price;
        this.description = description;
        this.stock = stock;
        this.weight = weight;
        this.keywords = keywords;
        this.promotion_start_time = promotion_start_time;
        this.promotion_end_time = promotion_end_time;
        this.promotion_per_limit = promotion_per_limit;
        this.promotion_type = promotion_type;
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(String promotion_price) {
        this.promotion_price = promotion_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getPromotion_start_time() {
        return promotion_start_time;
    }

    public void setPromotion_start_time(String promotion_start_time) {
        this.promotion_start_time = promotion_start_time;
    }

    public String getPromotion_end_time() {
        return promotion_end_time;
    }

    public void setPromotion_end_time(String promotion_end_time) {
        this.promotion_end_time = promotion_end_time;
    }

    public String getPromotion_per_limit() {
        return promotion_per_limit;
    }

    public void setPromotion_per_limit(String promotion_per_limit) {
        this.promotion_per_limit = promotion_per_limit;
    }

    public String getPromotion_type() {
        return promotion_type;
    }

    public void setPromotion_type(String promotion_type) {
        this.promotion_type = promotion_type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

