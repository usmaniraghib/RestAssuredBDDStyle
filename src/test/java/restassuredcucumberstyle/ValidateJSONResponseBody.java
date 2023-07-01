package restassuredcucumberstyle;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ValidateJSONResponseBody {
	
	Response response =	null;
			
	//@Test(priority=1)
	public void testJSONResponseBody1() {
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("book[0].title", equalTo("This is my title"))			
			.log().all();
	}
	
	@Test(priority=2)
	public void testJSONResponseBody2() {
		response =	
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		
		String bookTitle = response.jsonPath().get("book[0].title").toString();
		System.out.println("Book Title : "+bookTitle);
	}
	
	@Test(priority=3)
	public void testJSONResponseBody3() {
		response =	
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		
		String bookTitle = response.jsonPath().get("book[0].title").toString();
		Assert.assertEquals(bookTitle, "This is my title");
	}
	
	@Test(priority=4)
	public void testJSONResponseBody4() {
		response =	
		given()
			//.contentType("application/json")
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");	
		
		JSONObject jsonObject = new JSONObject(response.asString());
		
		for(int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
			String bookTitle = jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println("Book Title : "+bookTitle);
		}
		
		boolean status = false;
		for(int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
			String bookTitle = jsonObject.getJSONArray("book").getJSONObject(i).getString("title").toString();
			if(bookTitle.equals("This is my title")) {
				status = true;
				break;
			}
		}		
		Assert.assertEquals(status, true);
	}
}
