package com.eMall.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("loginDao")
public interface LoginDao {
    String findSellerPassword(@Param("seller_name") String seller_name);
}
