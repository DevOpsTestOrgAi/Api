package com.ensa.aiapi.controllers;

import com.ensa.aiapi.services.SuggestionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/suggestions")
@AllArgsConstructor
public class SuggestionsController {
    private final SuggestionsService suggestionsService;
    // Calling the scraping api to retrieve the products using the given url
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<String>> getSuggestedUrlsSearches(
//            @RequestParam("url") String url){
//        return ResponseEntity.ok().body(suggestionsService.getSuggestedUrlsSearches(url));
//    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> test(
            ){
        return ResponseEntity.ok().body("hello");
    }
}
