package com.eMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.eMall.dto.CartBaseInfo;
import com.eMall.entity.Cart;
import com.eMall.entity.Commodity;
import com.eMall.service.CartService;
import com.eMall.service.CommodityService;
import com.eMall.util.RandomNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    @Qualifier("cartService")
    private CartService cartService;

    @Autowired
    @Qualifier("commodityService")
    private CommodityService commodityService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addToCart(@RequestParam String cid, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        Commodity commodity = commodityService.findOneCommodity(cid);
        long buy_id = 1L;
        long shop_id = commodity.getShop_id();
        int num = 1;
        BigDecimal total_price = new BigDecimal(num).multiply(commodity.getPromotion_price());
        Timestamp cart_time = new Timestamp(System.currentTimeMillis());
        int cart_state = 0;
        Cart cart = new Cart(buy_id,shop_id,Long.valueOf(cid),num,total_price,cart_time,cart_state);
        try {
            cartService.addToCart(cart);
            jsonObject.put("state","success");
        }catch (Exception e){
            jsonObject.put("state","fail");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public List<CartBaseInfo> showCart(){
        List<CartBaseInfo> list = cartService.showCartItemsByBuyerId("1");
        return list;
    }
}
