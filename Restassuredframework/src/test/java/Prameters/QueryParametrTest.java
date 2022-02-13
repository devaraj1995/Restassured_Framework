package Prameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParametrTest {
	
	@Test
	public void queryparameter() {
		
		given()
		.queryParam("delay", "7")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	
		
	}

}
