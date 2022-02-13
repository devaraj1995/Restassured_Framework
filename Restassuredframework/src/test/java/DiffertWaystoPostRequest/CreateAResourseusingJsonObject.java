package DiffertWaystoPostRequest;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateAResourseusingJsonObject {
	@Test
	public void createjsonobject() {
		Random ran=new Random();
		int randomnum = ran.nextInt(300);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Devaraj");
		jobj.put("projectName", "hai"+randomnum);
		jobj.put("status", "Created");
		jobj.put("teamSize", 772);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();	
	}

}
