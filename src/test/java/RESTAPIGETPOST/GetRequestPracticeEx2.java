package RESTAPIGETPOST;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestPracticeEx2 {
@Test
public void GetUserData() {
// Base URI
	RestAssured.baseURI= "https://reqres.in/api/users";
	// Request Object 
  RequestSpecification http = RestAssured.given();
  Response response = http.request(Method.GET,"?page=2");
  // TO print Response Body 
  String responsebody = response.getBody().asPrettyString();
  System.out.println("Response Body :"+responsebody);
  // To Read Status Code 
  int statuscode = response.getStatusCode();
  System.out.println("Status Code :"+statuscode);
  // To print status line 
  String Statusline = response.getStatusLine();
  System.out.println("Status Line:"+Statusline);
  Assert.assertEquals( Statusline,response.getStatusLine());
  Assert.assertEquals(statuscode, 200);
  
}
}
