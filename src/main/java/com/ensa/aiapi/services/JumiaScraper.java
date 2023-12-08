package com.ensa.aiapi.services;
import com.ensa.aiapi.model.JumiaResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
@Service
public class JumiaScraper {

    public JumiaResponse scrapeJumia(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            String title = document.select("h1").text();
            String category = document.select("div.brcbs.col16.-pts.-pbm a:nth-child(3)").text();
            return new JumiaResponse("", title, category);
        } catch (Exception e) {
            return new JumiaResponse("Error occurred during scraping", "", "");
        }
    }
}