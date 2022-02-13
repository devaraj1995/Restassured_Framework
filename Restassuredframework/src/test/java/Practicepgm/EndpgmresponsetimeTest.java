package Practicepgm;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class EndpgmresponsetimeTest {

	
	@Test
public void verify() {
		
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat()
		.time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
		.log().all();
		
		
		
	}
}
