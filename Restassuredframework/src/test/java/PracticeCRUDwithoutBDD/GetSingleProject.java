package PracticeCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	@Test
	
	public void getsingleproject() {
		
		//step-1
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_002");
		
		//step-2
	System.out.println(resp.prettyPeek());
	//	System.out.println(resp.prettyPrint());
	  //System.out.println(resp.getStatusCode());
		//System.out.println(resp.getContentType());	
	}

}
