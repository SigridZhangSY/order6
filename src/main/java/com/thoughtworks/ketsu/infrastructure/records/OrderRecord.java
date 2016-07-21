package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.Payment;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PaymentMapper;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by syzhang on 7/20/16.
 */
public class OrderRecord implements Order, Record {
    private long id;
    private long userId;
    private String name;
    private String address;
    private String phone;
    private float totalPrice;
    private Date time;
    private List<OrderItemRecord> items;

    public OrderRecord(long userId, long id){
        this.userId = userId;
        this.id = id;
    }

    public OrderRecord(){

    }

    @Inject
    PaymentMapper paymentMapper;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public List<OrderItemRecord> getItems() {
        return items;
    }

    @Override
    public Payment createPayment(Map<String, Object> info) {
        info.put("order_id", id);
        paymentMapper.save(info);

        return paymentMapper.findByOrderId(id);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("uri", routes.orderUri(OrderRecord.this));
            put("name", name);
            put("address", address);
            put("phone", phone);
            put("total_price", totalPrice);
            put("create_at", time);
            List<Map<String, Object>> orderItems = new ArrayList<Map<String, Object>>();
            for(int i = 0; i < items.size(); i++){
                Map<String, Object> map = new HashMap<>();
                map.put("product_id", items.get(i).getProductId());
                map.put("quantity", items.get(i).getQuantity());
                map.put("amount", items.get(i).getAmount());
                orderItems.add(map);
            }
            put("order_items", orderItems);
        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("uri", routes.orderUri(OrderRecord.this));
            put("name", name);
            put("address", address);
            put("phone", phone);
            put("total_price", totalPrice);
            put("create_at", time);
        }};
    }
}
