
package com.ensa.aiapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@Data
public  class Product {

    private String id;
    private String title;
    private String imageUrl;
    private String productUrl;
    private String price;

    // Constructor with a generated unique ID
    public Product(String title, String imageUrl, String productUrl, String price) {
        this.id = generateUniqueId();
        this.title = title;
        this.imageUrl = imageUrl;
        this.productUrl = productUrl;
        this.price = price;
    }

    // Generate a unique ID using UUID
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }


}