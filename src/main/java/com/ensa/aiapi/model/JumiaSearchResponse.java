package com.ensa.aiapi.model;

import lombok.Data;

import java.util.List;
@Data
public class JumiaSearchResponse {
    private String errorMessage;
    private List<JumiaProduct> products;

    public JumiaSearchResponse(String errorMessage, List<JumiaProduct> products) {
        this.errorMessage = errorMessage;
        this.products = products;
    }

    // getters and setters
}
