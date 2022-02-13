package DiffertWaystoPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAResourseUsingJsonFile {
	
	@Test
	
	public void createjsonfile() {
	
		File file = new File("./createdata.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
