package com.yxy.market1.service;

import com.yxy.market1.entity.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product);

    Product findProductById(Integer id);

    List<Product> findProductByIdIn(List<Integer> ids);

    List<Product> findProductByNameLike();

    List<Product> findAllProduct();
}
