package Prameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojolibrary.pojaclass;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostRequestChainingTest {
	
	@Test
	public void chaining() {
		Random ran=new Random();
		int randomnum = ran.nextInt(300);
		pojaclass pojo = new pojaclass("devaraja", "happiss"+randomnum, "completed", 12);
		 Response resp = given()
		  .body(pojo)
		  .contentType(ContentType.JSON)
		  
		  .when()
		  .post("http://localhost:8084/addProject");

		 String projID = resp.jsonPath().get("projectId");
		 given().pathParam("proj", projID)
		 
		.delete("http://localhost:8084/projects/{proj}")
		 
		 .then()
		  .statusCode(204)
		  .contentType(ContentType.JSON)
		  .log().all();
		  
		  
		 
				 
				 
				
		
	}

}
