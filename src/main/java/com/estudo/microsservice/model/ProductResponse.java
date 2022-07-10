package com.estudo.microsservice.model;


import java.math.BigDecimal;

public class ProductResponse {

    private String name;
    private String description;
    private BigDecimal price;


    public ProductResponse(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

}
