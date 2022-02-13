package ResponseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojolibrary.pojaclass;

import static io.restassured.RestAssured.*;

public class CreatemultpleDataTest {
	
	@Test(dataProvider = "getData")
	
	public void create(String createdBy, String projectName, String status, int teamSize) {
		
		pojaclass pojo = new pojaclass(createdBy, projectName,status,teamSize);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();	
	}
@DataProvider
public Object[][] getData(){
	Object[][] objarray=new Object[2][4];
	objarray[0][0]="darshan";
	objarray[0][1]="sony123";
	objarray[0][2]="completed";
	objarray[0][3]=2271;
	
	objarray[1][0]="divya";
	objarray[1][1]="Tys12234";
	objarray[1][2]="completed";
	objarray[1][3]=277;
	
	return objarray;
	
	
}
}
