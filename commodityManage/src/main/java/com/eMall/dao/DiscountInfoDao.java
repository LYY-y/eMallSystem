package com.eMall.dao;

import com.eMall.entity.DiscountInfo;

import java.util.List;

public interface DiscountInfoDao {
    //插入
    void insertDiscountInfo(DiscountInfo discountInfo);

    //删除
    void deleteDiscountInfoById(String discount_id);

    //修改
    void updateDiscountInfo(DiscountInfo discountInfo);

    //查询所有优惠信息
    List<DiscountInfo> selectAllDiscountInfo();

    //模糊查询指定优惠信息
    List<DiscountInfo> selectDiscountInfoByEMall();
    List<DiscountInfo> selectDiscountInfoByShop();

    //多参数精确查询指定优惠信息
    DiscountInfo selectDiscountInfoById(String discount_id);
}
