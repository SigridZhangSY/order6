package com.thoughtworks.ketsu.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHelper {
    private static int auto_increment_key = 1;

    public static Map<String, Object> productMap(String name){
        return new HashMap<String, Object>(){{
            put("name", name);
            put("description", "red apple");
            put("price", 1.2);
        }};
    }

    public static Map<String, Object> userMap(String name){
        return new HashMap<String, Object>(){{
            put("name", name);
        }};
    }

    public static Map<String, Object> orderMap(String name, long productId){
        return new HashMap<String, Object>(){{
            put("name", name);
            put("address", "beijing");
            put("phone", "12300000000");
            List<Map<String, Object>> items = new ArrayList<>();
            items.add(new HashMap<String, Object>(){{
                put("product_id", productId);
                put("quantity", 2);
            }});
            put("order_items", items);
        }};
    }

    public static Map<String, Object> paymentMap(){
        return new HashMap<String, Object>(){{
            put("pay_type", "CASH");
            put("amount", 100);

        }};
    }

}
