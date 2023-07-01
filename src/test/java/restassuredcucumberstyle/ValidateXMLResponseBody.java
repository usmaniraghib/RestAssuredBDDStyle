package restassuredcucumberstyle;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ValidateXMLResponseBody {
	
	Response response = null;
	
	//@Test(priority=1)
	void testXMLResponse() {
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
			.log().all();
	}
	
	//@Test(priority=2)
	void testXMLResponse1() {
		response =
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/xml; charset=utf-8");
		
		String pageNo = response.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");
		
		String TraverseName = response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(TraverseName, "Developer");
	}
	
	@Test(priority=3)
	void testXMLResponse3() {
		response =
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		XmlPath xmlPathObject = new XmlPath(response.asString());
		
		List<String> allTravelerinformation = xmlPathObject.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(allTravelerinformation.size(), 10);
		
		List<String> travelerinformationName = xmlPathObject.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status = false;
		
		for(String travelerName : travelerinformationName) {
			System.out.println("Name : "+travelerName);
		}
	}
	
	//@Test(priority=4)
	void testXMLResponse4() {
		response =
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		XmlPath xmlPathObject = new XmlPath(response.asString());
		
		List<String> allTravelerinformation = xmlPathObject.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(allTravelerinformation.size(), 10);
		
		List<String> travelerinformationName = xmlPathObject.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status = false;
		
		for(String travelerName : travelerinformationName) {
			if(travelerName.equals("Developer")) {
				status = true;
				break;
			}
		}		
		Assert.assertEquals(status,true);
	}
}
