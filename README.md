
# Library
The library of characters, locations and episodes from the Rick and Morty show. Project takes data from external api https://rickandmortyapi.com/ and saves to local database every 10 minutes. You can navigate the site using the relevant http queries.


## API Reference

#### Get all characters

```http
  GET /character/all
```
| Query String | Type     | Description                       |
| :--------    | :------- | :-------------------------------- |
| `page`       | `integer`| **Optional**. Page number         |


#### Search for character

```http
  GET /character/search
```

| Query String | Type     | Description                                             |
| :--------    | :------- | :--------------------------------                       |
| `name`       | `string` | **Required**. Character name or full location name      |
| `page`       | `integer`| **Optional**. Page number                               |


#### Get all episodes

```http
  GET /episode/all
```
| Query String | Type     | Description                       |
| :--------    | :------- | :-------------------------------- |
| `page`       | `integer`| **Optional**. Page number         |


#### Search for episode

```http
  GET /episode/search
```

| Query String | Type     | Description                       |
| :--------    | :------- | :-------------------------------- |
| `name`       | `string` | **Required**. Episode name        |
| `page`       | `integer`| **Optional**. Page number         |


#### Get all locations

```http
  GET /location/all
```
| Query String | Type     | Description                       |
| :--------    | :------- | :-------------------------------- |
| `page`       | `integer`| **Optional**. Page number         |


#### Search for location

```http
  GET /location/search
```

| Query String | Type     | Description                       |
| :--------    | :------- | :-------------------------------- |
| `name`       | `string` | **Required**. Location name       |
| `page`       | `integer`| **Optional**. Page number         |

