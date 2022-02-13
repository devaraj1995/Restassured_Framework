package DiffertWaystoPostRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojolibrary.pojaclass;



public class CreateAResourseusingPojotest {
	
	@Test
	
	public void createpojo() {
		pojaclass pojo = new pojaclass("devaraj", "happy", "completed",222);
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	} 

}
