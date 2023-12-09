package com.ensa.aiapi.services;

import com.ensa.aiapi.feignClient.FeignAIInterface;
import com.ensa.aiapi.model.JumiaResponse;
import com.ensa.aiapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SuggestionService {
    @Autowired
    JumiaScraper jumiaScraper;

    @Autowired
    private FeignAIInterface aiAppFeignClient;

    @Autowired
    private JumiaSearcher jumiaSearcher;

    public List<Product> getSuggestedProducts(String url) {
        JumiaResponse jumiaResponse = jumiaScraper.scrapeJumia(url);
        List<String> suggestedKeywords = aiAppFeignClient.getSuggestedKeywords(jumiaResponse.getCategory());
        List<Product> allProducts = new ArrayList<>();

        for (String keyword : suggestedKeywords) {
            try {
                // Introduce a 500-millisecond delay
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Preserve the interrupted status
                Thread.currentThread().interrupt();
                // Log or handle the exception appropriately
                e.printStackTrace();
            }

            List<Product> products = jumiaSearcher.searchJumia(keyword);

            // Check for null before adding to allProducts
            if (products != null) {
                allProducts.addAll(products);
            }
        }

        // Shuffle the list after adding all products
        Collections.shuffle(allProducts);

        return allProducts;
    }
}
