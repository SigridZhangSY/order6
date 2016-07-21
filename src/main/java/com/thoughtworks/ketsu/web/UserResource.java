package com.thoughtworks.ketsu.web;


import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.records.OrderRecord;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserResource {
    private User user;

    public UserResource(User user){
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
        return user;
    }

    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrderForUser(Map<String, Object> info,
                                       @Context Routes routes){
        List<String> fields = new ArrayList<>();
        if(info.getOrDefault("name", "").toString().trim().isEmpty())
            fields.add("name");
        if(info.getOrDefault("address", "").toString().trim().isEmpty())
            fields.add("address");
        if(info.getOrDefault("phone", "").toString().trim().isEmpty())
            fields.add("phone");
        if(info.getOrDefault("order_items", "").toString().trim().isEmpty())
            fields.add("order_items");
        if(fields.size() > 0)
            throw new InvalidParameterException(fields);
        Order order = user.createOrder(info);
        return Response.created(routes.orderUri(order)).build();
    }

    @GET
    @Path("orders")
    @Produces(MediaType.APPLICATION_JSON)
    public String listOrdersForUser(){
        return "OK";
    }
}
