package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Order;
import com.yxy.market1.mapper.OrderMapper;
import com.yxy.market1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        orderMapper.save(order);
    }
}
