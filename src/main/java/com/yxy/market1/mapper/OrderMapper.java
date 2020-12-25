package com.yxy.market1.mapper;

import com.yxy.market1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderMapper extends JpaRepository<Order,Integer> {
    @Query
    List<Order> findOrderBySellerIdAndStatus(Integer sellerid, String status);

    @Procedure(name = "in_only_test")
    void inOnlyTest(@Param("inParam1") String inParam1);
}
