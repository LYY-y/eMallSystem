package com.eMall.service.impl;
import com.eMall.dao.OrderDao;
import com.eMall.entity.Order;
import com.eMall.entity.OrderCommodity;
import com.eMall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean createOrder(Order order, List<OrderCommodity> orderCommodities) {
        try {
            orderDao.insertOrder(order);
            for (OrderCommodity orderCommodity:orderCommodities) {
                orderDao.insertOrderCommodity(orderCommodity);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
