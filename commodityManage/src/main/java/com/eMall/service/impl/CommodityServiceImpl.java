package com.eMall.service.impl;

import com.eMall.dao.CommodityDao;
import com.eMall.entity.Commodity;
import com.eMall.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

//    @Resource(name = "commodityDao")
//    private CommodityDao dao;

    @Override
    public void auditCommodityInfo(Commodity commodity) {
//        dao.insertCommodity(commodity);
        System.out.println("成功编辑商品信息");
    }
}
