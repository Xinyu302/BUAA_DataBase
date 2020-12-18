package com.yxy.market1.service;

import com.yxy.market1.entity.Order;

import java.util.List;

public interface IOrderService {
    void createOrder(Order order);

    List<Order> getOrderUnComplete(Integer id);

    List<Order> getOrderCompleted(Integer id);

    Order getOrderById(Integer id);

}
