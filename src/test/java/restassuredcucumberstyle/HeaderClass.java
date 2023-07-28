package restassuredcucumberstyle;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderClass {
	
	@Test
	void getAllHeaders() {
		
		Response response = given().when().get("https://www.google.com/");
		
		Headers headerValues = response.getHeaders();		
		
		for(Header header : headerValues) {
			System.out.println("Key : "+header.getName());
			System.out.println("Value : "+header.getValue());
		}		
	}
}
