package com.eMall.service;

import com.eMall.dto.CartBaseInfo;
import com.eMall.entity.Cart;

import java.util.List;

public interface CartService {
    void addToCart(Cart cart);
    List<CartBaseInfo> showCartItemsByBuyerId(String buyer_id);
}
