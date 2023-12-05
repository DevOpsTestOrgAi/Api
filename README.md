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
    - A list of links to suggested results that match the given product
