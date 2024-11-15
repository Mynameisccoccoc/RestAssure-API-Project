package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteResponse {
	@Test
	public void testput() {
		JSONObject req = new JSONObject(); //this is dependency we added to make json
		
		req.put("name", "Abz");
		req.put("job", "Teacher");
		
		System.out.println(req.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
			header("Conent-Type","appliction/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
		log().all();	
		
	}
	
	@Test
	public void testPatch() {
		JSONObject req = new JSONObject(); //this is dependency we added to make json
		
		req.put("name", "Abz");
		req.put("job", "Teacher");
		
		System.out.println(req.toJSONString());
		
		baseURI="https://reqres.in";
		
		given().
			header("Conent-Type","appliction/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
		log().all();	
		
	}
	
	@Test
	public void testDelete() {
		
		
		baseURI="https://reqres.in";
		
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
		log().all();	
		
	}
}
