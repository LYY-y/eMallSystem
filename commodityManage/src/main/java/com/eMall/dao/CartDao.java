package com.eMall.dao;

import com.eMall.dto.CartBaseInfo;
import com.eMall.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component("cartDao")
public interface CartDao {
    void insertCart(Cart cart);
    List<CartBaseInfo> selectAllCartItemsByBuyerId(@Param("buyer_id") Long buyer_id);
}
