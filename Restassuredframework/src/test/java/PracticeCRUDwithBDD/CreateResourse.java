package PracticeCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResourse {
	
	@Test
	
	public void createresourse() {
		
	Random ran=new Random();
	int randomnum = ran.nextInt(300);
	
	JSONObject jobj=new JSONObject();//put =its belong hashmap=its used to create object
	jobj.put("createdBy", "anusha");
	jobj.put("projectName", "devishass27"+randomnum);
	jobj.put("status", "Created");
	jobj.put("teamSize", 22);
	
	given()          //precondition
	.body(jobj)
	.contentType(ContentType.JSON)
	.when()         //action
	.post("http://localhost:8084/addProject")
	.then()         //validation
	.assertThat().statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();
	
		
	}

}
;