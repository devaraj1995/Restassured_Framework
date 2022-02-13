package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {
	
	@Test
	public void verify() {
	
		String expectedprojectname="Sad";
	Response resp = when()
		.get("http://localhost:8084/projects");
    List<String> projectname = resp.jsonPath().get("projectName");
    boolean flag=false;
    for (String pname : projectname) {
    	try {
    	if (pname.equals(expectedprojectname)) {
    		flag=true;
    	}
    	}
		catch (Exception e) {
	
		}
	}
    resp.then()
    .assertThat()
    .contentType(ContentType.JSON)
    .statusCode(200)
    .log().all();
   Assert.assertEquals(flag,true);
		
		
	}

}
