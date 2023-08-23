package restassuredcucumberstyle;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

public class FileUploadDownload {
	
	public static String uploadFilePath = System.getProperty("user.dir");

	@Test(priority = 1)
	void singleFileUpload() {
		File fileObject = new File(uploadFilePath+"\\Picture\\"+"1Script-Generator-Location.JPG");
		System.out.println("fileObject : " + fileObject);
		given()
			.multiPart("file", fileObject)
			.contentType("multipart/form-data")
		.when()
			.post("https://the-internet.herokuapp.com/upload")
		.then()
			.statusCode(200)
			.log().all();
	}

	@Test(priority=2)
	void multipleFileUpload() {	// TODO Program Pending to implement.
		File fileObject1 = new File(uploadFilePath+"\\Picture\\"+"2Inspect-Element.JPG");
		System.out.println("fileObject1 : " + fileObject1);
		File fileObject2 = new File(uploadFilePath+"\\Picture\\"+"3Script-file-with-au3-extension.JPG");
		System.out.println("fileObject2 : " + fileObject2);
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
	void fileDownload() {	// TODO Program Pending to implement.
		given()
		.when()
			.get("https://the-internet.herokuapp.com/upload")
		.then()
			.statusCode(200)
			.log().all();
	}

}
