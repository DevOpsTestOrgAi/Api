package com.ensa.aiapi.feignClient;

import com.ensa.aiapi.dtos.ScrapingApiOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "scraping-searching-api",url = "http://172.30.0.2:9999")
public interface FeignAIInterface {
    @RequestMapping(value = "/scraper", method = RequestMethod.GET)
    ResponseEntity<ScrapingApiOutput> getSuggestedCategoryAndTitle(@RequestParam("url") String url);

    // Feed the AI the category
    @RequestMapping(value = "/keywords", method = RequestMethod.GET)
    ResponseEntity<List<String>> getSuggestedKeywordsByCategory(@RequestParam("category") String category);

    // Generate the links using the keywords the AI outputs
    @RequestMapping(value = "/searcher", method = RequestMethod.GET)
    ResponseEntity<List<String>> getSuggestedUrlsSearches(@RequestParam("keyword") String keyword);
}
