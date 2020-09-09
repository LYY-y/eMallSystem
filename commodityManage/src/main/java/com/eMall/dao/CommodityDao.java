package com.eMall.dao;

import com.eMall.entity.Commodity;
import com.eMall.entity.CommodityPic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("commodityDao")
public interface CommodityDao {
    void insertCommodity(@Param("commodity")Commodity commodity);

    void insertCommodityPic(@Param("commodityPic") CommodityPic commodityPic, @Param("cid")long cid);

    void deleteCommodityById(@Param("cid") long cid);

    void updateCommodity(Commodity commodity);

    List<Commodity> selectHotCommodities();
    List<Commodity> selectRemoveCommodities();
    List<Commodity> selectDiscountedCommodities();

    List<Commodity> selectAllBasicCommodities();

    List<String> selectCommodityAllPics(@Param("cid") long cid);

    Commodity selectOneCommodityInfoById(@Param("cid") long cid);

}
