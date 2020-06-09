package com.eMall.dao;

import com.eMall.entity.FreightInfo;

import java.math.BigInteger;
import java.util.List;

public interface FreightInfoDao {
    //插入
    void insertFreightInfo(FreightInfo freightInfo);

    //删除
    void deleteFreightInfoById(String fe_id);

    //修改
    void updateFreightInfo(FreightInfo freightInfo);

    //查询最后一条记录的id
    BigInteger seletLastFreightId();

    //查询所有物流运费信息
    List<FreightInfo> selectAllFreightInfo();

    //模糊查询指定物流配送信息
    List<FreightInfo> selectFreightInfoByFrom(String from_area);
    List<FreightInfo> selectFreightInfoByTo(String to_area);

    //多参数精确查询指定信息
    FreightInfo selectFreightInfoByFromAndTo(String from_area, String to_area);
}
