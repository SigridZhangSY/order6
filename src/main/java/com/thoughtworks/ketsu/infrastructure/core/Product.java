package com.thoughtworks.ketsu.infrastructure.core;

/**
 * Created by syzhang on 7/20/16.
 */
public interface Product {
    long getId();
    String getName();
    String getDescription();
    float getPrice();
}
