package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class UserRecord implements User, Record{
    private long id;
    private String name;

    public UserRecord(long id){
        this.id = id;
    }

    public UserRecord(){
    }

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
}
