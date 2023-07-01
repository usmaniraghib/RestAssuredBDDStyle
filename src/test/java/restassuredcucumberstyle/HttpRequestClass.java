package restassuredcucumberstyle;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

/*

Gerkin-Keywords:-

given() -> CONTENT TYPE, SET COOKIES, ADD AUTHENTICATION, ADD PARAM, SET HEADER INFORMATION AND ETC... 
		
when() -> GET, POST, PUT, DELETE...

then() -> VALIDATE STATUS CODE, EXTRACT RESPONSE, EXTRACT HEADERS COOKIES AND RESPONSE BODY....

 */

public class HttpRequestClass {
	
	int id;
	
	//@Test
	@Test(priority=1)
	void performGetAllRequest() {
				
		given()
				
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	
	//@Test
	@Test(priority=2)
	void performGetRequest() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//@Test
	//@Test(priority=3)
	void performPostRequest() {
		Map data = new HashMap();
		data.put("name", "Raghib");
		data.put("job", "Tester");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.log().all();
	}
	
	//@Test
		@Test(priority=4)
		void performPostRequest1() {
			Map data = new HashMap();
			data.put("name", "Raghib");
			data.put("job", "Tester");
			
			id = given()
				.contentType("application/json")
				.body(data)
				
			.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");
			
			System.out.println("Id : "+id);
		}
	
	//@Test
	@Test(priority=5, dependsOnMethods= {"performPostRequest1"})
	void performPutRequest() {
		Map data = new HashMap();
		data.put("name", "Raghib");
		data.put("job", "Automation-Tester");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=6, dependsOnMethods= {"performPutRequest"})
	void performDeleteRequest() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
}
