package restassuredcucumberstyle;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadDownload {

	@Test(priority = 1)
	void singleFileUpload() {
		File fileObject = new File("C:\\Users\\raghi\\Downloads\\Documents\\Ticket Opening Date.jpg");
		given()
			.multiPart("file", fileObject)
			.contentType("multipart/form-data")
		.when()
			.post("https://the-internet.herokuapp.com/upload")
		.then()
			.statusCode(200)
			.log().all();
	}

	// @Test(priority=2)
	void multipleFileUpload() {	//THIS IS INCOMPLETE
		File fileObject1 = new File("C:\\Users\\raghi\\Downloads\\Documents\\Ticket Opening Date.jpg");
		File fileObject2 = new File("C:\\Users\\raghi\\Downloads\\Documents\\SBO-Maintenance_BarCode.jpg");
		given()
			.multiPart("files", fileObject1)
			.multiPart("files", fileObject2)
			.contentType("multipart/form-data")
		.when()
			.post("https://the-internet.herokuapp.com/upload")
		.then()
			.statusCode(200)
			.log().all();
	}

	// @Test(priority=2)
	void fileDownload() {	//THIS IS INCOMPLETE
		given()
		.when()
			.get("https://the-internet.herokuapp.com/upload")
		.then()
			.statusCode(200)
			.log().all();
	}

}
