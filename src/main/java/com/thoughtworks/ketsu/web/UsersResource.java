package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.core.UserRepository;
import com.thoughtworks.ketsu.infrastructure.records.UserRecord;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;
import com.thoughtworks.ketsu.web.UserResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("users")
public class UsersResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Map<String, Object> info,
                               @Context Routes routes,
                               @Context UserRepository userRepository){
        List<String> fields = new ArrayList<>();
        if(info.getOrDefault("name", "").toString().trim().isEmpty())
            fields.add("name");
        if(fields.size() > 0)
            throw new InvalidParameterException(fields);
        return Response.created(routes.userUri(userRepository.createUser(info))).build();
    }

    @Path("{userId}")
    public UserResource getUserById(@PathParam("userId") long userId,
                                    @Context UserRepository userRepository){
        User user = userRepository.findUserById(userId).get();
        return new UserResource(user);
    }
}
