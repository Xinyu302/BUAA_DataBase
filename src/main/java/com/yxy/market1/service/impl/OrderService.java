package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Order;
import com.yxy.market1.mapper.OrderMapper;
import com.yxy.market1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        orderMapper.save(order);
    }

    @Override
    public List<Order> getOrderUnComplete(Integer id) {
        return orderMapper.findOrderBySellerIdAndStatus(id, "未完成");
    }

    @Override
    public List<Order> getOrderCompleted(Integer id) {
        return orderMapper.findOrderBySellerIdAndStatus(id,"已完成");
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.findById(id).get();
    }
}
