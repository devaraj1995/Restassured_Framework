package DiffertWaystoPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAresourseusingHashMap {
	
	@Test
	public void creahashmap() {
	
		HashMap map = new HashMap();
		map.put("CreatedBy", "devaraj");
		map.put("projectName", "Tyss");
		map.put("status", "Created");
		map.put("teamSize", 222);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
	}

}
