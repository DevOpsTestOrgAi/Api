package com.ensa.aiapi.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScrapingApiOutput {
    private String category;
    private String title;
    private String errorMessage;
}
