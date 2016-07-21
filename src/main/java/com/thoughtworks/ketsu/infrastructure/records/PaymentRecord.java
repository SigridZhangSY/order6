package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.Payment;

/**
 * Created by syzhang on 7/21/16.
 */
public class PaymentRecord implements Payment {
    private long orderId;
    private long productId;
    private int quantity;
    private float amount;

    public PaymentRecord(long orderId){
        this.orderId = orderId;
    }

    @Override
    public long getOrderId() {
        return orderId;
    }

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
