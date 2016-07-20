package com.thoughtworks.ketsu.web;


import com.thoughtworks.ketsu.infrastructure.core.User;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class UserResource {
    private User user;

    public UserResource(User user){
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(){
        return "OK";
    }
}
