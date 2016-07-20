package com.thoughtworks.ketsu.infrastructure.records;

import com.thoughtworks.ketsu.infrastructure.core.Product;


public class ProductRecord implements Product {
    private long id;
    private String name;
    private String description;
    private float price;

    public ProductRecord(long id){
        this.id = id;
    }

    public ProductRecord(){

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
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
