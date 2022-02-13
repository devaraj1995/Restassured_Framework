package Practicepgm;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class post {
@Test
public void postchain() {

	String expectedprojectname="TY_PROJ_1006";
Response resp = when()
	.delete("http://localhost:8084/projects");
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
