package com.lao.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.ValidatableResponse;

public class RestassuredExample 
{
	
	
	@Test(groups= {"get"})
	public void testingRestAssured()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		ValidatableResponse d=RestAssured.given()
		.param("", "")
		.when()
		.get("?page=2")
		.then()
		.statusCode(200);
		
	}
	
	
	@Test(groups= {"post"})
	public void postRestassuredExample()
	{
		JSONObject js = new JSONObject();
		js.put("name", "Abili");
		js.put("job", "UNKNOWN");
		System.out.println(js.toString());
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured
		.given()
		.body(js.toJSONString())
		.when()
		.post()
		.then()
		.statusCode(201);
		
		
	}
	
	@Test(groups= {"put"})
	public void putRestassuredExample()
	{
		JSONObject js = new JSONObject();
		js.put("name", "Alex");
		js.put("job", "QA");
		System.out.println(js.toString());
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured
		.given()
		.body(js.toJSONString())
		.when()
		.put("/2")
		.then()
		.statusCode(200);
		
	}
	
	@Test(groups= {"delete"})
	
	public void deleteRestAssuredExample()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured
		.given()
		.when()
		.delete("/2")
		.then()
		.statusCode(204);
	}

}
