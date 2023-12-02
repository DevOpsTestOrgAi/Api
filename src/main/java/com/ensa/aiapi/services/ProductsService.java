package com.ensa.aiapi.services;

import com.ensa.aiapi.feignClient.FeignProductsInterface;
import com.ensa.aiapi.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsService {
    private final FeignProductsInterface feignProductsInterface;
    public List<Product> getSuggestedProductsByUrl(
            String url,
            Double price){
        List<Product> products = feignProductsInterface.getSuggestedProductsByUrl(url).getBody();
        // Do the filtering on the products(price, ...)
        return products;
    }
}
