package com.eMall.service.impl;

import com.eMall.dao.FreightInfoDao;
import com.eMall.entity.FreightInfo;
import com.eMall.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("freightService")
public class FreightServiceImpl implements FreightService {
    @Autowired
    FreightInfoDao freightInfoDao;

    @Override
    public FreightInfo findFreightInfoByFromAndTo(String from, String dest){
        FreightInfo freightInfo = freightInfoDao.selectFreightInfoByFromAndTo(from,dest);
        return freightInfo;
    }
}
