package com.yxy.market1.mapper;

import com.yxy.market1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends JpaRepository<Product,Integer> {

}
