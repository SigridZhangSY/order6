package com.thoughtworks.ketsu.support;

import java.util.HashMap;
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

}
