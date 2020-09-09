package com.eMall.entity;

public class CommodityPic {
    private long img_id;
    private String pic_path;
    private int order;


    public CommodityPic() {
    }

    public CommodityPic(long img_id, String pic_path, int order) {
        this.img_id = img_id;
        this.pic_path = pic_path;
        this.order = order;
    }

    public long getImg_id() {
        return img_id;
    }

    public void setImg_id(long img_id) {
        this.img_id = img_id;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
