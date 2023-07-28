package restassuredcucumberstyle;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathAndQueryParameters {
	
	/* https://reqres.in/api/users?delay=3 */
	
	@Test
	void testParameters() {
		given()
			.pathParam("myapi", "api")
			.pathParam("myusers", "users")
			.queryParam("delay", 3)
		
		.when()
			.get("https://reqres.in/{myapi}/{myusers}")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
