package com.ensa.aiapi.services;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JumiaScrapingService {

    public List<String> scrapeCatElements() {
        List<String> extractedElements = new ArrayList<>();

        try {
            // Replace the URL with the actual URL you want to scrape
            String url = "https://www.jumia.ma/";
            Document document = Jsoup.connect(url).get();

            // Select the div.flyout element
            Element flyout = document.selectFirst("div.flyout[role=menu]");

            // Check if flyout element is not null
            if (flyout != null) {
                // Select the elements with class sub inside flyout
                Elements subElements = flyout.select(".sub");


               for (Element subElement : subElements) {
                  // Select the elements with class sub-w inside sub
                 Elements subWElements = subElement.select(".sub-w");

                   for (Element subWElement : subWElements) {
                        // Select the elements with class co inside sub-w
                       Elements coElements = subWElement.select(".co");

                        for (Element coElement : coElements) {
                           // Select the elements with class cat inside co
                            Elements catElements = coElement.select(".cat");

                       for (Element catElement : catElements) {
/                               // Select all child elements of the cat element
//                                Elements allCatChildElements = catElement.children();
//
//                                for (Element catChildElement : allCatChildElements) {
//                                    // Extract the HTML content of each child element
//                                    String elementHtml = catChildElement.outerHtml();
//                                    extractedElements.add(elementHtml);
//                                }
//                            }
//                        }
//                    }
 //               }
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return extractedElements;
    }
}
