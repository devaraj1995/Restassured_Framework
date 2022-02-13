package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
	
	@Test
	
	public void create() {
		String expectprojectName="Sad";
		Response resp = when()
		.get("http://localhost:8084/projects");
		String actualprojectname = resp.jsonPath().get("[1].projectName");
		
		resp.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		Assert.assertEquals(expectprojectName, actualprojectname);
		
		
		
		
		
		
	}

}
