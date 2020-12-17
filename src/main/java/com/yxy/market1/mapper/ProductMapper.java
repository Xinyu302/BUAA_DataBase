package com.yxy.market1.mapper;

import com.yxy.market1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends JpaRepository<Product,Integer> {
    @Query
    List<Product> findByIdIn(List<Integer> ids);
}
