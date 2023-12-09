## Jumia Scraper API

The Jumia Scraper API allows users to extract information from a specific product page on the Jumia website.

### Get Product Details

Retrieve details about a product from a given Jumia product page URL.

- **URL**
    - `/jumia/scraper`

- **Method**
    - `GET`

- **Parameters**
    - `url` (String): The Jumia product page URL (Query param) from which product details are requested.

- **Example**
    ```http
    GET http://20.112.50.189/jumia/scraper?url=<write your jumia url>
    ```

- **Response**
    - Product details including title, category, and other relevant information.
    - String errorMessage;
    - String title;
     - String category;

## Jumia Searcher API

The Jumia Searcher API allows users to search for products on Jumia based on a given keyword.

### Search for Products

Retrieve a list of products that match the given keyword on Jumia.

- **URL**
    - `/jumia/searcher`

- **Method**
    - `GET`

- **Parameters**
    - `keyword` (String): The keyword (Query param) for which product search is requested.

- **Example**
    ```http
    GET http://20.112.50.189/jumia/searcher?keyword=<write your keyword>
    ```

- **Response**
    - A list of products containing details such as title, image URL, product URL, and price.
    -    String errorMessage
    -    list of products{
    -    String title
    -    String imageUrl
    -    String productUrl
    -    String price }



# Suggestions API

The Suggestions API provides suggestions based on a given URL using web scraping.


## API Endpoint

### Get Suggestions

Retrieve suggested URLs based on the input URL.

- **URL**
    - `/api/v1/suggestions`

- **Method**
    - `GET`

- **Parameters**
    - `url` (String): The input URL(Query param) for which suggestions are requested.
 


- **Example**
  ```http
  GET /api/v1/suggestions?url=https://www.jumia.ma/smart-watch-t500-montre-intelligente-smart-watsh-full-appel-etanche-frequence-cardiaque-58887120.html

- **Response**
    - A list of links, suggested results that match the given product
