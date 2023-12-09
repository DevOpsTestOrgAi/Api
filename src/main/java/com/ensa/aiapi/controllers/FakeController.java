package com.ensa.aiapi.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v2/suggestions")
public class FakeController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> getAllProducts(@RequestParam String url) {
        // Construct and return the specified JSON response
        return Arrays.asList(
                createProductList1(),
                createProductList2()
        );
    }

    private Object createProductList1() {
        return new Response("",
                Arrays.asList(
                        new Product("Microsoft SURFACE LAPTOP GO TACTILE i5-10eme Génération 8GB/128GB - QWERTY", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/75/775936/1.jpg?3884", "https://www.jumia.ma/microsoft-surface-laptop-go-tactile-i5-10eme-generation-8gb128gb-qwerty-63957757.html", "7,490.00 Dhs"),
                        new Product("Hp Laptop 14s-dq0033nf 4Go Ram 64Go EMMC 14 pouces AZERTY neuf", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/50/829146/1.jpg?1208", "https://www.jumia.ma/hp-laptop-14s-dq0033nf-4go-ram-64go-emmc-14-pouces-azerty-neuf-64192805.html", "2,600.00 Dhs"),
                        new Product("Microsoft surface Laptop 3-13.3\"Tactile-i5 1035G7-128 SSD-8GB-Azerty-Win10Pro-Garantie12 Mois", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/99/369904/1.jpg?1466", "https://www.jumia.ma/microsoft-surface-laptop-3-13.3tactile-i5-1035g7-128-ssd-8gb-azerty-win10pro-garantie12-mois-40996399.html", "9,900.00 Dhs"),
                        new Product("Hp Laptop EliteBook CORE i5-6eme RAM 8Go/SSD 256Go Pack Gratuit -Remis à neuf", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/60/739316/1.jpg?3896", "https://www.jumia.ma/hp-laptop-elitebook-core-i5-6eme-ram-8gossd-256go-pack-gratuit-remis-a-neuf-61393706.html", "2,799.00 Dhs"),
                        new Product("Inspirational Quote Stickers Aesthetic Motivational Decal Stickers for Laptop Scrapbooking Journal Kids Toys lot/25 pcs", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/72/333126/1.jpg?0065", "https://www.jumia.ma/generic-inspirational-quote-stickers-aesthetic-motivational-decal-stickers-for-laptop-scrapbooking-journal-kids-toys-lot25-pcs-62133327.html", "35.00 Dhs")
                )
        );
    }

    private Object createProductList2() {
        return new Response("",
                Arrays.asList(
                        new Product("Kingston SSD SATA : KC600 - 1 TB -15X PLUS RAPIDE // DISQUE FLASH - REV 3.0", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/82/442146/1.jpg?1012", "https://www.jumia.ma/kingston-ssd-sata-kc600-1-tb-15x-plus-rapide-disque-flash-rev-3.0-64124428.html", "845.00 Dhs"),
                        new Product("Lenovo SSD 512 Go pour ordinateur portable, et PC de bureau", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/95/093146/1.jpg?2778", "https://www.jumia.ma/lenovo-ssd-512-go-pour-ordinateur-portable-et-pc-de-bureau-64139059.html", "449.00 Dhs"),
                        new Product("Kodak Disque Dur SSD 1TB Internal 1000 GB", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/72/118736/1.jpg?9070", "https://www.jumia.ma/kodak-disque-dur-ssd-1tb-internal-1000-gb-63781127.html", "700.00 Dhs"),
                        new Product("Lenovo SSD 512 Go disque dur interne", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/97/114236/1.jpg?4625", "https://www.jumia.ma/lenovo-ssd-512-go-disque-dur-interne-63241179.html", "459.00 Dhs"),
                        new Product("Kodak SSD 512 Go pour ordinateur portable et PC bureau", "https://ma.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/25/093146/1.jpg?2777", "https://www.jumia.ma/kodak-ssd-512-go-pour-ordinateur-portable-et-pc-bureau-64139052.html", "459.00 Dhs")
                )
        );
    }

    private static class Response {
        public String errorMessage;
        public List<Product> products;

        public Response(String errorMessage, List<Product> products) {
            this.errorMessage = errorMessage;
            this.products = products;
        }
    }

    private static class Product {
        public String title;
        public String imageUrl;
        public String productUrl;
        public String price;

        public Product(String title, String imageUrl, String productUrl, String price) {
            this.title = title;
            this.imageUrl = imageUrl;
            this.productUrl = productUrl;
            this.price = price;
        }
    }
}
