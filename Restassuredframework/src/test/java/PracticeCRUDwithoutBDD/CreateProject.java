package PracticeCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createProject() {
	
	
	//step- create test data
		JSONObject jobj=new JSONObject();//json simple=depedenceies
		jobj.put("createdBy", "Devaraj");
		jobj.put("projectName", "devisha");
		jobj.put("status", "Created");
		jobj.put("teamSize", 12);
		
		//step-2 create request specification
		RequestSpecification reqs = RestAssured.given();
		reqs.contentType(ContentType.JSON);//cont =use for specific reqs or respnose
		reqs.body(jobj);
		
		//step-3 perform the action 
		Response resp = reqs.post("http://localhost:8084/addProject");
		
		//step-4 print in console and verify
		
		System.out.println(resp.asString());
		System.out.println(resp.getContentType());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
	}

}
