package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.ProductRepository;
import com.thoughtworks.ketsu.infrastructure.records.ProductRecord;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("products")
public class ProductResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Map<String, Object> info,
                                  @Context Routes routes,
                                  @Context ProductRepository productRepository){
        List<String> fields = new ArrayList<>();
        if(info.getOrDefault("name", "").toString().trim().isEmpty())
            fields.add("name");
        if(info.getOrDefault("description", "").toString().trim().isEmpty())
            fields.add("description");
        if(info.getOrDefault("price", "").toString().trim().isEmpty())
            fields.add("price");
        if(fields.size() > 0)
            throw new InvalidParameterException(fields);
        return Response.created(routes.productUri(productRepository.createProduct(info))).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listProducts(@Context ProductRepository productRepository){
        return productRepository.getAllProduct();
    }

    @GET
    @Path("{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product findProductById(@PathParam("productId") long productId,
                                   @Context ProductRepository productRepository){
        return productRepository.findProductById(productId).orElseThrow(() -> new NotFoundException("product not found"));
    }
}
