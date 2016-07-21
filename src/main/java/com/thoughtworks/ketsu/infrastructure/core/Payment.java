package com.thoughtworks.ketsu.infrastructure.core;

import java.util.Date;

/**
 * Created by syzhang on 7/21/16.
 */
public interface Payment {
    long getOrderId();
    String getPayType();
    float getAmount();
    Date getTime();
}
