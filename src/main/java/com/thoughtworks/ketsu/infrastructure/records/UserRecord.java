package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.User;

public class UserRecord implements User{
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
}
