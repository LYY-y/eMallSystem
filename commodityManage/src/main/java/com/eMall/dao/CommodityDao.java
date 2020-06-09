package com.eMall.dao;

import com.eMall.entity.Commodity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("commodityDao")
public interface CommodityDao {
    void insertCommodity(Commodity commodity);
    void deleteCommodityById(String com_id);
    void updateCommodity(Commodity commodity);

    List<Commodity> selectAllCommodities();
    List<Commodity> selectCommoditySortByPriceASC();

}
