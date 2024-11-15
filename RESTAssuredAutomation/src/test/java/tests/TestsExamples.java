package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //if we put static an * mark in the end we can directly get the statement see line 12
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestsExamples {
@Test
	public void test_1() {
		Response res = /*RestAssured.*/get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

@Test
public void test_2() {
	baseURI="https://reqres.in/api";
	/*given().get("/users?page=2").then().statusCode(200);*/
	                   //OR
	given().
		get("/users?page=2").
	then().
		statusCode(200).
	body("data[1].id",equalTo(8)).
		log().all();//by adding this line all the json data will appear in console
}
}

