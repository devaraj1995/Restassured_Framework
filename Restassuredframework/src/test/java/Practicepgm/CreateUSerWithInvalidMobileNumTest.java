package Practicepgm;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUSerWithInvalidMobileNumTest {
	@Test
	public void create() {
		Random ran=new Random();
		int randomnum = ran.nextInt(300);
		JSONObject jobj=new JSONObject();
		jobj.put("designation","SDET");
		  jobj.put("dob",25/05/1999);
		  jobj.put("email","devarajreddy@gmail.com"+randomnum);
		  jobj.put("empName","devanu"+randomnum);
		  jobj.put("experience",3.2);
		  jobj.put("mobileNo","93221456781111");
		  jobj.put("project","hdfc"+randomnum);
		  jobj.put("role","ROLE_ADMIN");
		  jobj.put("username","devaraj"+randomnum);
		  
		  given()
		  .body(jobj)
		  .contentType(ContentType.JSON)
		  .when()
		  .post("http://localhost:8084/employees")
		  .then()
		  .assertThat()
		  //.statusCode(201)
		  .contentType(ContentType.JSON)
		  .log().all();
	
	}

}
