package com.ensa.aiapi.services;
import com.ensa.aiapi.model.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JumiaSearcher {

    public List<Product> searchJumia(String keyword) {
        try {
            String searchUrl = "https://www.jumia.ma/catalog/?q=" + keyword;
            Document document = Jsoup.connect(searchUrl).get();

            List<Product> products = new ArrayList<>();

            // Select product elements within the specified class
            Elements productElements = document.select("div.-paxs.row._no-g._4cl-3cm-shs article.prd._fb.col.c-prd");

            for (Element productElement : productElements) {
                String title = productElement.select("h3.name").text();
                String imageUrl = productElement.select("img.img").attr("data-src");
                String productUrl = "https://www.jumia.ma" + productElement.select("a.core").attr("href");
                String price = productElement.select("div.prc").text();

                products.add(new Product(title, imageUrl, productUrl, price));

                // Break the loop if we have collected 10 products
                if (products.size() >= 5) {
                    break;
                }
            }

            return products;
        } catch (Exception ignored) {
            return  null;

        }
    }
}
