package com.ensa.aiapi.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ai-v1-model-app", url = "http://ai-v1-model-app-svc")
public interface FeignAIInterface {

    @GetMapping("/ai/suggest")
    List<String> getSuggestedKeywords(@RequestParam("input") String input);
}
