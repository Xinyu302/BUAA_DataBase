package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Product;
import com.yxy.market1.mapper.ProductMapper;
import com.yxy.market1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProduceService implements IProductService {
    @Autowired
    ProductMapper pMapper;

    @Override
    public void createProduct(Product product) {
        pMapper.save(product);
    }

    @Override
    public List<Product> findProductById() {
        return null;
    }

    @Override
    public List<Product> findProductByNameLike() {
        return null;
    }
}
