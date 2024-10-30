package com.example.CustomQuery.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private String category;


    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

}
