package com.eMall.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.eMall.entity.enums.Promotion;
import com.eMall.entity.enums.State;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

//商品实体类
@Component("commodity")
public class Commodity implements Serializable {
    //货号，商家自填
    private long commodity_id = 0;
    private int brand_id = 0;
    private int category_id;
    private String title;
    private State status = State.REVIEWING;
    private int sale = 0;
    private BigDecimal price;
    private BigDecimal promotion_price;
    private String description;
    private int stock = 1000;
    private BigDecimal weight = new BigDecimal(0);
    private String keywords = "";
    private Timestamp promotion_start_time = null;
    private Timestamp promotion_end_time = null;
    private int promotion_per_limit = 0;
    private Promotion promotion_type = Promotion.NONE;
    private Timestamp publish_time;
    private long shop_id;
    private String main_pic;
    private String place;

    @JsonSerialize(using=ToStringSerializer.class)
    private Long cid;

    public Commodity() {
    }

    public Commodity(long commodity_id, int brand_id, int category_id, String title, State status,
                     int sale, BigDecimal price, BigDecimal promotion_price, String description,
                     int stock, BigDecimal weight, String keywords, Timestamp promotion_start_time,
                     Timestamp promotion_end_time, int promotion_per_limit, Promotion promotion_type,
                     Timestamp publish_time, long shop_id, String main_pic, long cid,String place) {
        this.commodity_id = commodity_id;
        this.brand_id = brand_id;
        this.category_id = category_id;
        this.title = title;
        this.status = status;
        this.sale = sale;
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
        this.publish_time = publish_time;
        this.shop_id = shop_id;
        this.main_pic = main_pic;
        this.cid = cid;
        this.place = place;
    }

    public long getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(long commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(BigDecimal promotion_price) {
        this.promotion_price = promotion_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Timestamp getPromotion_start_time() {
        return promotion_start_time;
    }

    public void setPromotion_start_time(Timestamp promotion_start_time) {
        this.promotion_start_time = promotion_start_time;
    }

    public Timestamp getPromotion_end_time() {
        return promotion_end_time;
    }

    public void setPromotion_end_time(Timestamp promotion_end_time) {
        this.promotion_end_time = promotion_end_time;
    }

    public int getPromotion_per_limit() {
        return promotion_per_limit;
    }

    public void setPromotion_per_limit(int promotion_per_limit) {
        this.promotion_per_limit = promotion_per_limit;
    }

    public Promotion getPromotion_type() {
        return promotion_type;
    }

    public void setPromotion_type(Promotion promotion_type) {
        this.promotion_type = promotion_type;
    }

    public Timestamp getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Timestamp publish_time) {
        this.publish_time = publish_time;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    @JsonProperty
    public String  getCid() {
        return String.valueOf(this.cid);
    }


    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodity_id=" + commodity_id +
                ", brand_id=" + brand_id +
                ", category_id=" + category_id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", sale=" + sale +
                ", price=" + price +
                ", promotion_price=" + promotion_price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", weight=" + weight +
                ", keywords='" + keywords + '\'' +
                ", promotion_start_time=" + promotion_start_time +
                ", promotion_end_time=" + promotion_end_time +
                ", promotion_per_limit=" + promotion_per_limit +
                ", promotion_type=" + promotion_type +
                ", publish_time=" + publish_time +
                ", shop_id=" + shop_id +
                ", main_pic='" + main_pic + '\'' +
                ", place='" + place + '\'' +
                ", cid=" + cid +
                '}';
    }
}
