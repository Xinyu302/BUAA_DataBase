package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Product;
import com.yxy.market1.mapper.ProductMapper;
import com.yxy.market1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ProduceService implements IProductService {
    @Autowired
    ProductMapper pMapper;

    @Override
    public Product createProduct(Product product) {
        return pMapper.save(product);
    }

    @Override
    public Product findProductById(Integer id) {
        if (!pMapper.findById(id).isPresent()) {
            return null;
        }
        return pMapper.findById(id).get();
    }

    @Override
    public List<Product> findProductByNameLike() {
        return null;
    }
}
