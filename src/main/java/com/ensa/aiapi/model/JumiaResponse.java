package com.ensa.aiapi.model;

import lombok.Data;

@Data
public class JumiaResponse {
    private String errorMessage;
    private String title;
    private String category;

    public JumiaResponse(String errorMessage, String title, String category) {
        this.errorMessage = errorMessage;
        this.title = title;
        this.category = category;
    }

    // Getters and setters
}
