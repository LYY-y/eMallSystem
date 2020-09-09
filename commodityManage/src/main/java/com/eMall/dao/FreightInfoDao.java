package com.eMall.dao;

import com.eMall.entity.FreightInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("freightDao")
public interface FreightInfoDao {
    //多参数精确查询指定信息
    FreightInfo selectFreightInfoByFromAndTo(@Param("from") String from, @Param("dest") String dest);

    //插入
    void insertFreightInfo(FreightInfo freightInfo);

    //删除
    void deleteFreightInfoById(String fe_id);

    //修改
    void updateFreightInfo(FreightInfo freightInfo);

    //查询所有物流运费信息
    List<FreightInfo> selectAllFreightInfo();

    //模糊查询指定物流配送信息
    List<FreightInfo> selectFreightInfoByFrom(String from_area);
    List<FreightInfo> selectFreightInfoByTo(String to_area);


}
