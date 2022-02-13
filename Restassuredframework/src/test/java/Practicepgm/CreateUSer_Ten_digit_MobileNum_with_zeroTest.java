package Practicepgm;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateUSer_Ten_digit_MobileNum_with_zeroTest {
	@Test
	public void create() {
		
		Random ran=new Random();
		int randomnum = ran.nextInt(300);
	 
		JSONObject jobj=new JSONObject();
	
		jobj.put("designation","devops");
		jobj.put("dob",25/05/1999);
		jobj.put("email","anusha@gmail.com");
		jobj.put("empName","anusha");
		jobj.put("experience",7);
		jobj.put("mobileNo",0000000000);
		jobj.put("project","dumbu"+randomnum);
		jobj.put("role","ROLE_ADMIN");
		jobj.put("username","anusha");
		
		
		given()
		
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat()
		.statusCode(409)
		.and()
		.contentType(ContentType.JSON)
		.and()
		.log().all();

		
	}

}
