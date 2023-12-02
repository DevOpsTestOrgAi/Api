package com.ensa.aiapi.feignClient;

import com.ensa.aiapi.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("someRouteToScrapingApi/suggestions")
public interface FeignProductsInterface {
    @RequestMapping(value = "api/v1/suggestions", method = RequestMethod.GET)
    ResponseEntity<List<Product>> getSuggestedProductsByUrl(@RequestParam("url") String query);
}
