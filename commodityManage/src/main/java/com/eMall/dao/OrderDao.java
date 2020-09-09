package com.eMall.dao;

import com.eMall.entity.Order;
import com.eMall.entity.OrderCommodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orderDao")
public interface OrderDao {
    void insertOrder(Order order);

    void insertOrderCommodity(OrderCommodity orderCommodity);

    List<Order> findOrderByBuyer(@Param("buyer_id")long buyer_id);

    List<OrderCommodity> findOrderCommodityByBuyer(@Param("order_id")long order_id);

    void deleteOrder(@Param("orderID")long order_id);




}
