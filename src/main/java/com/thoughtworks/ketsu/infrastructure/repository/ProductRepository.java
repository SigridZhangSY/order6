package com.thoughtworks.ketsu.infrastructure.repository;


import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;

import javax.inject.Inject;
import java.util.Map;

public class ProductRepository implements com.thoughtworks.ketsu.infrastructure.core.ProductRepository{

    @Inject
    ProductMapper productMapper;
    @Override
    public Product createProduct(Map<String, Object> info) {
        productMapper.save(info);

        return productMapper.findById(Long.valueOf(String.valueOf(info.get("id"))));
    }
}
