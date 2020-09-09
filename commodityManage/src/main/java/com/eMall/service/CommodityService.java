package com.eMall.service;

import com.eMall.entity.Commodity;
import com.eMall.entity.CommodityPic;

import java.util.List;

public interface CommodityService {
    void addCommodity(Commodity commodity, CommodityPic[] commodityPics, long cid);

    List<Commodity> findAllCommodities();

    void deleteCommodity(String cid);

    void updateCommodityInfo(Commodity commodity);

    Commodity findOneCommodity(String cid);

//    List<Commodity> lookUpAllCommoditiesByPriceOrder();
//    Commodity lookUpOneCommodityById();

}
