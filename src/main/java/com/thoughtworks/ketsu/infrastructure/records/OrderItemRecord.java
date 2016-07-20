package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.OrderItem;

/**
 * Created by syzhang on 7/20/16.
 */
public class OrderItemRecord implements OrderItem {
    private long productId;
    private int quantity;
    private float amount;

    @Override
    public long getProductId() {
        return productId;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public float getAmount() {
        return amount;
    }
}
