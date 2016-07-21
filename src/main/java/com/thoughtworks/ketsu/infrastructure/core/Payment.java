package com.thoughtworks.ketsu.infrastructure.core;

/**
 * Created by syzhang on 7/21/16.
 */
public interface Payment {
    long getOrderId();
    long getProductId();
    int getQuantity();
    float getAmount();
}
