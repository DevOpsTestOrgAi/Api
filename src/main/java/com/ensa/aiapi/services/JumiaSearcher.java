package com.ensa.aiapi.services;
import com.ensa.aiapi.model.JumiaProduct;
import com.ensa.aiapi.model.JumiaSearchResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JumiaSearcher {

    public JumiaSearchResponse searchJumia(String keyword) {
        try {
            String searchUrl = "https://www.jumia.ma/catalog/?q=" + keyword;
            Document document = Jsoup.connect(searchUrl).get();

            List<JumiaProduct> products = new ArrayList<>();

            // Select product elements within the specified class
            Elements productElements = document.select("div.-paxs.row._no-g._4cl-3cm-shs article.prd._fb.col.c-prd");

            for (Element productElement : productElements) {
                String title = productElement.select("h3.name").text();
                String imageUrl = productElement.select("img.img").attr("data-src");
                String productUrl = "https://www.jumia.ma" + productElement.select("a.core").attr("href");
                String price = productElement.select("div.prc").text();

                products.add(new JumiaProduct(title, imageUrl, productUrl, price));

                // Break the loop if we have collected 10 products
                if (products.size() >= 5) {
                    break;
                }
            }

            return new JumiaSearchResponse("", products);
        } catch (Exception e) {
            return new JumiaSearchResponse("Error occurred during searching", Collections.emptyList());
        }
    }
}
