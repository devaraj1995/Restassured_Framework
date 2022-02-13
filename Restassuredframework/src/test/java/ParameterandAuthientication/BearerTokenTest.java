package ParameterandAuthientication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	
	@Test
	public void bearerAuth() {
		given()
		.auth().oauth2("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")
		
		.when()
		.get("https://github.com/user/repos")
		.then()
		.statusCode(200)
		.assertThat()
		.log().all();
	
		
	}

}
