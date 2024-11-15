package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class GetPostResponse {
	
	@Test
	public void testGet() {
		baseURI="https://reqres.in/api";
			given().
		get("/users?page=2").
			then().
		statusCode(200).
			body("data[4].first_name", equalTo("George")).
		body("data.first_name",hasItems("George","Rachel"));
	
	}
	
	@Test
	public void testpost() {
		Map<String, Object> map=new HashMap<String,Object>();
//		map.put("name", "Abz");  
//		map.put("job", "Teacher");
//	
//		System.out.println(map);
		
		JSONObject req = new JSONObject(map); //this is dependency we added to make json
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
			post("/users").
		then().
			statusCode(201).
		log().all();	
	}
}
