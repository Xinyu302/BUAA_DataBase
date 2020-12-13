package com.yxy.market1.service;

import com.yxy.market1.entity.Product;

import java.util.List;

public interface IProductService {
    void createProduct(Product product);

    List<Product> findProductById();

    List<Product> findProductByNameLike();
}
