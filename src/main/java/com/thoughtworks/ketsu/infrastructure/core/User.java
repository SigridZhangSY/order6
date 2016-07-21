package com.thoughtworks.ketsu.infrastructure.core;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface User {
    long getId();
    String getName();

    Order createOrder(Map<String, Object> info);

    List<Order> listOrder();

    Optional<Order> findOrderById(long orderId);
}
