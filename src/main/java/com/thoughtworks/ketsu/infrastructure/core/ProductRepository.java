package com.thoughtworks.ketsu.infrastructure.core;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ProductRepository {
    Product createProduct(Map<String, Object> info);

    List<Product> getAllProduct();

    Optional<Product> findProductById(long productId);
}
