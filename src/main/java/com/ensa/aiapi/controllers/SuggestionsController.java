package com.ensa.aiapi.controllers;

import com.ensa.aiapi.model.JumiaSearchResponse;
import com.ensa.aiapi.services.JumiaScraper;
import com.ensa.aiapi.services.JumiaSearcher;
import com.ensa.aiapi.services.SuggestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/suggestions")
@AllArgsConstructor
public class SuggestionsController {


    private final SuggestionService suggestionsService;
    // Calling the scraping api to retrieve the products using the given url
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<JumiaSearchResponse>> getSuggestedUrlsSearches(
            @RequestParam("url") String url){
        return ResponseEntity.ok().body(suggestionsService.getSuggestedProducts(url));
    }

}
