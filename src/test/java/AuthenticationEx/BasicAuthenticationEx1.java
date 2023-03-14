package AuthenticationEx;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthenticationEx1 {
@Test
public void Ex1() {
	// Base Uri
	RestAssured.baseURI="https://postman-echo.com/";
	// Basic autherization 
	PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
	basicAuth.setUserName("postman");
	basicAuth.setPassword("password");
	RestAssured.authentication= basicAuth;
	
	//REquest Spesification 
	RequestSpecification httprequest= RestAssured.given();
    Response response = httprequest.request(Method.GET,"basic-auth");
     
    String responsebody= response.getBody().asPrettyString();
    System.out.println("Response Body :"+responsebody);
    System.out.println("Status code "+response.getStatusCode());
    Assert.assertEquals(response.statusCode(), 200);
}


}
