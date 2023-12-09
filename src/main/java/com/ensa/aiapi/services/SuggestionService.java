package com.ensa.aiapi.services;

import com.ensa.aiapi.feignClient.FeignAIInterface;
import com.ensa.aiapi.model.JumiaResponse;
import com.ensa.aiapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                // Introduce a 1-second delay
                Thread.sleep(500); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                // Handle the exception (e.g., log it)
                e.printStackTrace();
            }

            List<Product> products = jumiaSearcher.searchJumia(keyword);
            allProducts.addAll(products);
        }
        return allProducts;
    }
}
