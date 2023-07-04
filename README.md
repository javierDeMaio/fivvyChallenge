## Execution

1. Make sure you have Java 17, Maven and Docker installed on your machine.

2. Clone this repository:

3. Navigate to the project directory

4. run mvn clean install

5. run docker build -t backend .

6. go to src/main/resources and run "docker-compose up"


The application will run at http://localhost:8080.

## API Endpoints:

Here are the specifications to make requests to each endpoint of the project using Postman:

Endpoint: ## Create Acceptance##
Method: POST
URL: http://localhost:8080/api/acceptances
Body (raw - JSON):

{
    "disclaimerId": Long,
    "userId": Long
}

Endpoint 2: ##  Get Acceptance by User ID ## 
URL: http://localhost:8080/api/acceptances/{userId}

Method: GET


Endpoint 3: ## Get All Acceptances ## 
URL: http://localhost:8080/api/acceptances

Method: GET

Body (raw - JSON):

{
  "name": "Disclaimer 1",
  "text": "Lorem ipsum dolor sit amet.",
  "version": 1,
}

Endpoint 4: ##  Create Disclaimer ## 
URL: http://localhost:8080/api/disclaimer

Method: POST

Request Body:
{
  "name": "Disclaimer 1",
  "text": "Lorem ipsum dolor sit amet.",
}


Endpoint 5:##  Get Disclaimer by Text ## 
URL: http://localhost:8080/api/disclaimer?text=lorem

Method: GET


Endpoint 6: ## Get All Disclaimers ## 
URL: http://localhost:8080/api/disclaimer

Method: GET



Endpoint 7: ## Delete Disclaimers by id ## 

URL: http://localhost:8080/api/disclaimers/{id}

method: DELETE

Endpoint 8: ## Update Disclaimers by id ## 

URL:http://localhost:8080/api/disclaimers/{id}

Request Body:
{
    "name":"Disclaimer text updated",
    "text":"Disclaimer text updated"
}


The app is beyond 90% "successful" test, so it is presumed to be stable.

