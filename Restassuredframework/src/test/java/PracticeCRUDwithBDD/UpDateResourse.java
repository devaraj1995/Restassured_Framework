package PracticeCRUDwithBDD;


import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class UpDateResourse {
	
	@Test
	
	public void updateresourse() {
		
		Random ran=new Random();
		int randomnum = ran.nextInt(300);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "anusha ss");
		jobj.put("projectName", "devarajss"+randomnum);
		jobj.put("status", "Completed");
		jobj.put("teamSize", 27);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_402")
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

		
	}
		
		

