package com.ensa.aiapi.services;

import com.ensa.aiapi.dtos.ScrapingApiOutput;
import com.ensa.aiapi.feignClient.FeignAIInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SuggestionsService {
    private final FeignAIInterface feignAIInterface;
    public List<String> getSuggestedUrlsSearches(
            String url){
        // 1- Scrape the page by calling the scraping api
        ScrapingApiOutput scrapingApiOutput= feignAIInterface.getSuggestedCategoryAndTitle(url).getBody();
        if(scrapingApiOutput==null) return new ArrayList<>(); // Return a good format later

        // 2- Feed the AI the output of the scraping api
        List<String> keywords = feignAIInterface.getSuggestedKeywordsByCategory(scrapingApiOutput.getCategory()).getBody();
        if(keywords==null || keywords.isEmpty()) return new ArrayList<>(); // Return a good format later

        // 3- Feed the searcher AI the output of the AI suggestions model
        // This is juste for now, we are passing juste one item
        return feignAIInterface.getSuggestedUrlsSearches(keywords.get(0)).getBody();
    }
}
