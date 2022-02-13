package PracticeCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpDateProject {
	
@Test
public void updateproject() {
	
	//step-1
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Devaraj");
	jobj.put("projectName", "devisha");
	jobj.put("status", "completed");
	jobj.put("teamSize", 12);
	
	//step-2
	RequestSpecification reqs = RestAssured.given();
	reqs.contentType(ContentType.JSON);
	reqs.body(jobj);
	
	//step-3
	Response resp = reqs.put("http://localhost:8084/projects/TY_PROJ_402");
	
	//step-4
	ValidatableResponse validate = resp.then();
	validate.assertThat().statusCode(200);
	validate.log().all();
	
}

}
