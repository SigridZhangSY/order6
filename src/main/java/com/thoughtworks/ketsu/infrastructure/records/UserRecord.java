package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRecord implements User, Record{
    private long id;
    private String name;

    public UserRecord(long id){
        this.id = id;
    }

    public UserRecord(){
    }

    @Inject
    OrderMapper orderMapper;
    @Inject
    ProductMapper productMapper;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("uri", routes.userUri(UserRecord.this));
            put("name", name);
            put("id", id);
        }};
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Order createOrder(Map<String, Object> info) {
        info.put("user_id", id);
        float price = 0;
        List<Map<String, Object>> list = (List<Map<String, Object>>)info.get("order_items");
        for(int i = 0; i < list.size(); i++){
            Product product = productMapper.findById(Long.valueOf(String.valueOf(list.get(i).get("product_id"))));
            float amount = product.getPrice()*Integer.valueOf(String.valueOf(list.get(i).get("quantity")));
            price += amount;
            list.get(i).put("amount", amount);
        }
        info.put("total_price", price);
        orderMapper.save(info);
        return orderMapper.findById(Long.valueOf(String.valueOf(info.get("id"))));
    }

    @Override
    public List<Order> listOrder() {
        return orderMapper.getOrders(id);
    }

    @Override
    public Optional<Order> findOrderById(long orderId) {
        return Optional.ofNullable(orderMapper.findById(orderId));
    }
}
