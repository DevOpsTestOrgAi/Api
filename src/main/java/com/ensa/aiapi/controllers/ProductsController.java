package com.ensa.aiapi.controllers;

import com.ensa.aiapi.models.Product;
import com.ensa.aiapi.services.ProductsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    // Calling the scraping api to retrieve the products using the given url
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<Product>> getSuggestedProductsByUrl(
            @RequestParam("url") String url,
            @RequestParam("price") Double price){
        return ResponseEntity.ok(productsService.getSuggestedProductsByUrl(url, price));
    }
}
