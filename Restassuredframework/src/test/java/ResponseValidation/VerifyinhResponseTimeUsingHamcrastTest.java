package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyinhResponseTimeUsingHamcrastTest {
	
	@Test
	
	public void respone() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat()
		.time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
		.log().all();
		
		
	}
	


}
