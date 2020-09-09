package com.eMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.eMall.dto.OrderBaseInfo;
import com.eMall.entity.Commodity;
import com.eMall.entity.Order;
import com.eMall.entity.OrderCommodity;
import com.eMall.entity.User;
import com.eMall.service.CommodityService;
import com.eMall.service.LoginService;
import com.eMall.service.OrderService;
import com.eMall.util.RandomNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    @Autowired
    @Qualifier("commodityService")
    private CommodityService commodityService;

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public Object checkOrder(@RequestBody List<String> cids, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        try {
            Long order_id = RandomNumUtil.createId();
            Long buyer_id = 1L;
            Timestamp order_time = new Timestamp(System.currentTimeMillis());
            BigDecimal all_price = new BigDecimal(0);
            BigDecimal real_pay = new BigDecimal(0);
            BigDecimal weight = new BigDecimal(0);
            Commodity commodity = commodityService.findOneCommodity(cids.get(0));
            Long shop_id = commodity.getShop_id();
            String from_place = commodity.getPlace();
            int order_state = 0;//未付款
            int num = cids.size();
            List<Commodity> commodityList = new ArrayList<>();
            all_price = all_price.add(commodity.getPromotion_price());
            weight = weight.add(commodity.getWeight());
            commodityList.add(commodity);
            for (int i = 1; i < num; i++) {
                commodity = commodityService.findOneCommodity(cids.get(i));
                shop_id = commodity.getShop_id();
                all_price = all_price.add(commodity.getPromotion_price());
                weight.add(commodity.getWeight());
                commodityList.add(commodity);
            }
            real_pay = all_price;
            OrderBaseInfo orderBaseInfo = new OrderBaseInfo(order_id, buyer_id, shop_id, from_place, order_time, order_state, all_price, real_pay);
            map.put("orderBaseInfo", orderBaseInfo);
            map.put("commodities", commodityList);
            map.put("weight", weight);
            String uniqueId = String.valueOf(RandomNumUtil.createId());
            map.put("uniqueId", uniqueId);
            jsonObject.put("state", "success");
            jsonObject.put("uniqueId", uniqueId);
            session.setAttribute("orderMap", map);
        }catch (Exception e){
            jsonObject.put("state","fail");
        }finally {
            return jsonObject;
        }
    }

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    @ResponseBody
    public Object showOrder(@RequestBody String uniqueId, HttpSession session){
        Map<String, Object> map = (Map<String, Object>) session.getAttribute("orderMap");
        String uniqueSession = (String) map.get("uniqueId");
        if (uniqueSession.equals(uniqueId)){
            String secondSessionId = String.valueOf(RandomNumUtil.createId());
            map.put("secondSessionId", secondSessionId);
            return map;
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public Object createOrder(@RequestParam String dest_place,
                              @RequestParam String receiver_name,
                              @RequestParam String receiver_phone,
                              @RequestParam int pay_method,
                              @RequestParam BigDecimal freight,
                              @RequestParam BigDecimal all_price,
                              @RequestParam BigDecimal real_pay,
                              @RequestParam(value = "orderCommodities") List<Long> orderCommodities,
                              @RequestParam(value = "orderCommodityNumList") List<Integer> orderCommodityNumList,
                              @RequestParam(value = "orderCommoditySinglePriceList") List<BigDecimal> orderCommoditySinglePriceList,
                              HttpSession session){
        Map<String, Object> map = (Map<String, Object>) session.getAttribute("orderMap");
        String uniqueSession = (String) map.get("uniqueId");
        OrderBaseInfo orderBaseInfo = (OrderBaseInfo) map.get("orderBaseInfo");
        long order_id = orderBaseInfo.getOrder_id();
        Order order = new Order(order_id,orderBaseInfo.getBuyer_id(),orderBaseInfo.getShop_id(),
                orderBaseInfo.getFrom_place(),dest_place,orderBaseInfo.getOrder_time(),receiver_name,receiver_phone,
                orderBaseInfo.getOrder_state(),pay_method,freight,all_price,real_pay);
        List<OrderCommodity> orderCommodityList = new ArrayList<>();
        int orderItemNum = orderCommodities.size();
        for (int i=0; i < orderItemNum; i++){
            long cid = orderCommodities.get(i);
            int num = orderCommodityNumList.get(i);
            BigDecimal singlePrice = orderCommoditySinglePriceList.get(i);
            OrderCommodity orderCommodity = new OrderCommodity(order_id,cid,num,singlePrice,new BigDecimal(num).multiply(singlePrice));
            orderCommodityList.add(orderCommodity);
        }
        boolean state = orderService.createOrder(order,orderCommodityList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",state);
        return jsonObject;
    }
}
