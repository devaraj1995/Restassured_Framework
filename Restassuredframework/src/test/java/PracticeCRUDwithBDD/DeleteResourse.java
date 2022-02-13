package PracticeCRUDwithBDD;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteResourse {
	@Test
	
	public void deleteresourse() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_003")
		.then()
		.assertThat().statusCode(204)
		.log().all();

		
		
	}

}
