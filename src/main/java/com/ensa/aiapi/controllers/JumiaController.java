package com.ensa.aiapi.controllers;
import com.ensa.aiapi.services.JumiaScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jumia/api")
public class JumiaController {

    @Autowired
    private JumiaScrapingService scrapingService;

    @GetMapping("/scrape")
    public List<String> scrapeJumiaData() {
        return scrapingService.scrapeCatElements();
    }
}