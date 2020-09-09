package com.eMall.service;

import com.eMall.entity.FreightInfo;

public interface FreightService {
    FreightInfo findFreightInfoByFromAndTo(String from, String dest);
}
