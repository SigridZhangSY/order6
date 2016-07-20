package com.thoughtworks.ketsu.infrastructure.core;

/**
 * Created by syzhang on 7/20/16.
 */
public interface OrderItem  {
    long getProductId();
    int getQuantity();
    float getAmount();
}
