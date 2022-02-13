package Prameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	
	public void pathparametr() {
		given()
		.pathParam("projectId", "TY_PROJ_002")
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
	}

}
