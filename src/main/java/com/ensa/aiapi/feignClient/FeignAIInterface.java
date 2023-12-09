package com.ensa.aiapi.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ai-model-app",url = "http://10.244.1.119:8080")
public interface FeignAIInterface {
    @GetMapping("/api/v2/suggest-keywords")
    List<String> getSuggestedKeywords(
            @RequestParam String category);
}
