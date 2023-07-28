package restassuredcucumberstyle;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookieClass {
	
	@Test
	void getAllCookies() {
		
		Response response = given().when().get("https://www.google.com/");
		
		Map<String,String> cookieValues = response.getCookies();
		
		for(String key : cookieValues.keySet()) {
			String cookieValue = response.getCookie(key);
			System.out.println("Key : "+key+" Value : "+cookieValue);
		}		
	}
}
