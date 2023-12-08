package com.ensa.aiapi.controllers;
import com.ensa.aiapi.model.JumiaResponse;
import com.ensa.aiapi.model.JumiaSearchResponse;
import com.ensa.aiapi.services.JumiaScraper;
import com.ensa.aiapi.services.JumiaSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jumia")
public class JumiaController {

    @Autowired
    private JumiaScraper jumiaScraper;

    @Autowired
    private JumiaSearcher jumiaSearcher;

    @GetMapping("/scraper")
    public JumiaResponse handleScraper(@RequestParam String url) {
        return jumiaScraper.scrapeJumia(url);
    }

    @GetMapping("/searcher")
    public JumiaSearchResponse handleSearcher(@RequestParam String keyword) {
        return jumiaSearcher.searchJumia(keyword);
    }
}
