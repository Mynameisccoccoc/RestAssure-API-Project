package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestOnLocalAPI {
    
    //@Test
    public void get() {
        // Set the base URI for RestAssured requests
        baseURI = "http://localhost:3000";
        
        // Send a GET request to /users and validate the status code
        given()
            .when()
            .get("/users")
            .then()
            .statusCode(200) // Assert that the status code is 200
        	.log()
        	.all();
    }    
        
      //@Test
      public void post() {
    	  JSONObject req = new JSONObject();
    	  
    	  req.put("firstName", "Dubai");
    	  req.put("lastName", "Lolly");
    	  req.put("subjectId", 5);
    	  
    	  baseURI = "http://localhost:3000";
    	  
    	  given()
    	  .contentType(ContentType.JSON)
    	  .accept(ContentType.JSON)
    	  .body(req.toJSONString())
    	  .when()
    	  .post("/users")
    	  .then()
    	  .statusCode(201)
    	  .log()
    	  .all();
    	  
      }
      
      //@Test
      public void put() {
    	  JSONObject req = new JSONObject();
    	  
    	  req.put("firstName", "Albert");
    	  req.put("lastName", "Dolly");
    	  req.put("subjectId", 7);
    	  
    	  baseURI = "http://localhost:3000";
    	  
    	  given()
    	  .contentType(ContentType.JSON)
    	  .accept(ContentType.JSON)
    	  .body(req.toJSONString())
    	  .when()
    	  .put("/users/4")
    	  .then()
    	  .statusCode(200)
    	  .log()
    	  .all();
    }
     
      //@Test
      public void patch() {
    	  JSONObject req = new JSONObject();
    	  
    	  
    	  req.put("lastName", "Shaikh");
    	  
    	  
    	  baseURI = "http://localhost:3000";
    	  
    	  given()
    	  .contentType(ContentType.JSON)
    	  .accept(ContentType.JSON)
    	  .body(req.toJSONString())
    	  .when()
    	  .patch("/users/4")
    	  .then()
    	  .statusCode(200)
    	  .log()
    	  .all();
    }
      
      @Test
      public void delete() {
          // Base URI for the API
          baseURI = "http://localhost:3000";
          
          // Send DELETE request to remove user with ID 4
          when().delete("/users/4")
              .then()
              .statusCode(200)  // Assert the response status code is 200 OK
              .log().all();      // Optionally log the response for debugging purposes
      }

}

