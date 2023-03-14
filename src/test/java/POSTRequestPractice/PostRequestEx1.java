package POSTRequestPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestEx1 {
@Test
public void CreateCustomer() {
	// Base URI
	RestAssured.baseURI="https://reqres.in/api";
	RequestSpecification http = RestAssured.given();
	// Request For PayLOad 
	JSONObject param = new JSONObject();
	param.put("email", "eve.holt@reqres.in");
	param.put("password", "pistol");
	// Request PayLOad type in Header 
	http.header("Content-Type","application/json");
    // adding PayLoad TO reqest
	http.body(param.toJSONString());
	// Send The Response 
	Response response = http.request(Method.POST,"/login");
	String ResponseBody =response.asPrettyString();
	System.out.println("Response Body :"+ResponseBody);
    int stscode = response.statusCode();
    System.out.println("Status Code :"+stscode);
}
}

