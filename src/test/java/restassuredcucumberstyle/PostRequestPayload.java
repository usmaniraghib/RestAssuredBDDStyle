package restassuredcucumberstyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*

Gerkin-Keywords:-

given() -> CONTENT TYPE, SET COOKIES, ADD AUTHENTICATION, ADD PARAM, SET HEADER INFORMATION AND ETC... 
		
when() -> GET, POST, PUT, DELETE...

then() -> VALIDATE STATUS CODE, EXTRACT RESPONSE, EXTRACT HEADERS COOKIES AND RESPONSE BODY....

 */

/*
1) Using HashMap
2) Using org.json
3) Using POJO (Plain Old Java Object)
4) Using External JSON File
 */

public class PostRequestPayload {
	
	HashMap hashMapObject = null;
	
	StudentPojo studentPojoObject = null;
	
	File fileObject = null;
	FileReader fileReaderObject = null;
	JSONTokener jsonTokenerObject = null;
	JSONObject jsonDataObject = null;
		
	//@Test(priority=1)
	//Using HashMap
	void testPostRequestUsingHashMapData() {
		System.out.println("STARTED testPostRequestUsingHashMapData() METHOD");
		
		hashMapObject = new HashMap();
		
		hashMapObject.put("name", "Usmani");
		hashMapObject.put("location", "Bihar");
		hashMapObject.put("phone", "12345");
		
		String[] coursesArray = {"Java", "C"};
		hashMapObject.put("courses", coursesArray);
		
		given()
			.contentType("application/json")
			.body(hashMapObject)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Usmani"))
			.body("location", equalTo("Bihar"))
			.body("phone", equalTo("12345"))
			.body("courses[0]", equalTo("Java"))
			.body("courses[1]", equalTo("C"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();		
	}
	
	//@Test(priority=1)
	//Using org.json
//	<dependency>
//		<groupId>org.json</groupId>
//		<artifactId>json</artifactId>
//		<version>20220320</version>
//	</dependency>
	void testPostRequestUsingOrgJsonData() {
		System.out.println("STARTED testPostRequestUsingOrgJsonData() METHOD");
		
		jsonDataObject = new JSONObject();
		
		jsonDataObject.put("name", "Usmani");
		jsonDataObject.put("location", "Bihar");
		jsonDataObject.put("phone", "12345");
		
		String[] coursesArray = {"Java", "C"};
		jsonDataObject.put("courses", coursesArray);
		
		given()
			.contentType("application/json")
			.body(jsonDataObject.toString())
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Usmani"))
			.body("location", equalTo("Bihar"))
			.body("phone", equalTo("12345"))
			.body("courses[0]", equalTo("Java"))
			.body("courses[1]", equalTo("C"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();		
	}
	
	//@Test(priority=1)
	//Using POJO Class
	void testPostRequestUsingPojoData() {
		System.out.println("STARTED testPostRequestUsingPojoData() METHOD");
		
		studentPojoObject = new StudentPojo();
		
		studentPojoObject.setName("Usmani");
		studentPojoObject.setLocation("Bihar");
		studentPojoObject.setPhone("12345");
		
		String[] coursesArray = {"Java", "C"};
		studentPojoObject.setCourses(coursesArray);
		
		given()
			.contentType("application/json")
			.body(studentPojoObject)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Usmani"))
			.body("location", equalTo("Bihar"))
			.body("phone", equalTo("12345"))
			.body("courses[0]", equalTo("Java"))
			.body("courses[1]", equalTo("C"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();		
	}
	
	// @Test(priority=1)
	// Using External JSON File
	void testPostRequestUsingexternalJsonFileData() throws FileNotFoundException {
		System.out.println("STARTED testPostRequestUsingexternalJsonFileData() METHOD");

		File fileObject = new File(".\\body.json");
		FileReader fileReaderObject = new FileReader(fileObject);
		JSONTokener jsonTokenerObject = new JSONTokener(fileReaderObject);
		JSONObject jsonDataObject = new JSONObject(jsonTokenerObject);

		given().contentType("application/json").body(jsonDataObject.toString())

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("Aizah")).body("location", equalTo("US"))
				.body("phone", equalTo("5894")).body("courses[0]", equalTo("MBBS")).body("courses[1]", equalTo("MS"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}
	
	@Test(priority=1)
	//Using External JSON File
	void testPostRequestUsingexternalJsonFileData1() {
		System.out.println("STARTED testPostRequestUsingexternalJsonFileData1() METHOD");
		try {
			fileObject = new File(System.getProperty("user.dir")+"\\DataFolder\\body.json");
			fileReaderObject = new FileReader(fileObject);
			jsonTokenerObject = new JSONTokener(fileReaderObject);
			jsonDataObject = new JSONObject(jsonTokenerObject);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		given()
			.contentType("application/json")
			.body(jsonDataObject.toString())
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Aizah"))
			.body("location", equalTo("US"))
			.body("phone", equalTo("5894"))
			.body("courses[0]", equalTo("MBBS"))
			.body("courses[1]", equalTo("MS"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();		
	}
	
	//@Test(priority=2)
	void testDelete() {
		System.out.println("STARTED testDelete() METHOD");
		given()
		
		.when()
			.delete("http://localhost:3000/students/3")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
