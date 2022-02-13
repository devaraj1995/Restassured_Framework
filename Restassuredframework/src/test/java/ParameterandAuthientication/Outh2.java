package ParameterandAuthientication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Outh2 {
	@Test

	public void auth() {
		Response resp = given()
		.formParams("client_id", "bulletbasayya")
		.formParams("client_secret", "c62097a052bbeb1473c4ff074a42360d")
		.formParams("grant_type", "client_credentials")
		.formParams("redirect_uri", "https://example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
        String token = resp.jsonPath().get("access_token");
        
        given()
        .auth().oauth2(token)
        .pathParam("USER_ID", "2795")
        .when()
       // .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-fee")
        
        
        .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
        .then()
        .assertThat()
        .log().all();
        		
		
		
	}
	

}
