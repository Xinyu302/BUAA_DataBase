package com.yxy.market1.mapper;

import com.yxy.market1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMapper extends JpaRepository<Order,Integer> {
}
