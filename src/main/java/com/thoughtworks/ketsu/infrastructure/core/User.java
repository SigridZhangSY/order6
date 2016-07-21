package com.thoughtworks.ketsu.infrastructure.core;


import java.util.List;
import java.util.Map;

public interface User {
    long getId();
    String getName();

    Order createOrder(Map<String, Object> info);

    List<Order> listOrder();
}
