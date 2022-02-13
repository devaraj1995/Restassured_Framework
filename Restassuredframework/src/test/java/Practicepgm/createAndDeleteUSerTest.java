package Practicepgm;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import pojolibrary.PojoforEmp;

public class createAndDeleteUSerTest {
	

	
	@Test
	public void createDeleteUSer() {
		Random ran=new Random();
		int randomnum = ran.nextInt(300);
		
		PojoforEmp empDetails=new PojoforEmp("SDET"+randomnum, "25/05/1999", "devaraj@gmail.com", "Devaraj"+randomnum, 15, "9888777657", "Devaraj"+randomnum, 
				"ROLE_ADMIN","devaraj"+randomnum);
		 Response resp = given()
			.body(empDetails)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees");
		resp.then()
		
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.time(Matchers.lessThan(2200L), TimeUnit.MILLISECONDS);
			
		
		String empid=resp.jsonPath().get("employeeId");
		System.out.println(empid);
		given()
		.pathParam("userID", empid)
		
		.contentType(ContentType.JSON)
		.get("http://localhost:8084/employees/{userID}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(2200L), TimeUnit.MILLISECONDS)
		.log().all();
		
			
	}
}
