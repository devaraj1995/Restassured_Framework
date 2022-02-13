package PracticeCRUDwithoutBDD;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject {
	@Test
	public void getallproject() {
		
		
		//step-1
		int expstatus=200;
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//step-2
		System.out.println(resp.prettyPeek());
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
	}

}
