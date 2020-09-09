package com.eMall.service.impl;

import com.eMall.dao.LoginDao;
import com.eMall.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean sellerLogin(String seller_name, String seller_password) {
        return seller_password.equals(loginDao.findSellerPassword(seller_name));
    }
}
