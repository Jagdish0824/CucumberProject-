package APIPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestEx {
@Test
public void GetUserData() {
	System.out.println("We See in This Get Request");
	// Base Uri 
	RestAssured.baseURI="https://reqres.in/api/users";
	// Request Object 
	RequestSpecification http = RestAssured.given();
	Response response = http.request(Method.GET,"/2");
	// To print Response BOdy 
    String responsebody = response.asPrettyString();
    System.out.println("Response  Body"+responsebody);
    // TO print Status code 
    int stscode = response.getStatusCode();
    System.out.println("Status Code"+stscode);
    Assert.assertEquals(stscode, 200);
    System.out.println("Thank You");
}
}
//https://reqres.in/api/users/2

