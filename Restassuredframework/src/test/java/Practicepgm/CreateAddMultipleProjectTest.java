package Practicepgm;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojolibrary.PojoMultipleProject;

public class CreateAddMultipleProjectTest {
	@Test
	public void createmultiple() {
	Random ran=new Random();
	int randomnum = ran.nextInt(300);
	
	PojoMultipleProject pojo= new PojoMultipleProject("devaraj"+randomnum, "02/07/2022","TY_PROJ_202","happy"+randomnum,
			"Created",22);
	Response resp = given()
	.body(pojo)
	.contentType(ContentType.JSON)
	.when()
	.post("http://localhost:8084/addProject");
	
	resp.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(201)
	.time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
	.log().all();
	
	
	}
}
