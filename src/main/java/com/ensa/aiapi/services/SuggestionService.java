package com.ensa.aiapi.services;

import com.ensa.aiapi.feignClient.FeignAIInterface;
import com.ensa.aiapi.model.JumiaProduct;
import com.ensa.aiapi.model.JumiaResponse;
import com.ensa.aiapi.model.JumiaSearchResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionService {
    @Autowired JumiaScraper jumiaScraper;

    @Autowired
    private FeignAIInterface aiAppFeignClient;

    @Autowired
    private JumiaSearcher jumiaSearcher;

    public List<JumiaSearchResponse> getSuggestedProducts(String url) {

        JumiaResponse jumiaResponse=jumiaScraper.scrapeJumia(url);
        List<String> suggestedKeywords = aiAppFeignClient.getSuggestedKeywords(jumiaResponse.getCategory());
        List<JumiaSearchResponse> jumiaSearchResponseList=new ArrayList<>();
        for (String keyword : suggestedKeywords) {
            JumiaSearchResponse jumiaSearchResponses=jumiaSearcher.searchJumia(keyword);
            jumiaSearchResponseList.add(jumiaSearchResponses);
        }
        return jumiaSearchResponseList;
    }
}

