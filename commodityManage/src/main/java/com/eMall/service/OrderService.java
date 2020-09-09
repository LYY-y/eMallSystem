package com.eMall.service;

import com.eMall.entity.Order;
import com.eMall.entity.OrderCommodity;

import java.util.List;

public interface OrderService {
    boolean createOrder(Order order, List<OrderCommodity> orderCommodities);

}
