package com.eMall.service.impl;

import com.eMall.dao.CartDao;
import com.eMall.dto.CartBaseInfo;
import com.eMall.entity.Cart;
import com.eMall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public void addToCart(Cart cart) {
        cartDao.insertCart(cart);
    }

    @Override
    public List<CartBaseInfo> showCartItemsByBuyerId(String buyer_id) {
        return cartDao.selectAllCartItemsByBuyerId(Long.valueOf(buyer_id));
    }
}
