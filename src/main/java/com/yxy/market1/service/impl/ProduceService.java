package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Product;
import com.yxy.market1.mapper.ProductMapper;
import com.yxy.market1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduceService implements IProductService {
    @Autowired
    private ProductMapper pMapper;

    @Override
    public Product createProduct(Product product) {
        return pMapper.save(product);
    }

    @Override
    public Product findProductById(Integer id) {
        Optional<Product> product = pMapper.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    @Override
    public List<Product> findProductByIdIn(List<Integer> ids) {
        return pMapper.findByIdIn(ids);
    }

    @Override
    public List<Product> findProductByNameLike(String name) {
        String like = "%"+name+"%";
        return pMapper.findProductsByNameLike(like);
    }

    @Override
    public List<Product> findAllProduct() {
        return pMapper.findAll();
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        return pMapper.findProductsByCategory(category);
    }

    @Override
    public Integer findSellerIdById(Integer id) {
        return pMapper.findSellerIdById(id);
    }

    @Override
    public void setStatus(Integer id,String status) {
        pMapper.updateStatusById(id, status);
    }
}
