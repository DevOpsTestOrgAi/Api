package com.ensa.aiapi.model;

import lombok.Data;

@Data
public class JumiaProduct {
    private String title;
    private String imageUrl;
    private String productUrl;
    private String price;

    public JumiaProduct(String title, String imageUrl, String productUrl, String price) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.productUrl = productUrl;
        this.price = price;
    }

    // getters and setters
}
