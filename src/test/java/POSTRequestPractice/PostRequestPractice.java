package POSTRequestPractice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestPractice {
@Test
public void CreateUser() {
	// Base Url
	RestAssured.baseURI="https://reqres.in/api";
    RequestSpecification httprequest =RestAssured.given();
    
    // How to Add Request Payload 
    JSONObject requestparam = new JSONObject();
    requestparam.put("name", "eve.holt@reqres.in");
    requestparam.put("job", "pistol");
    
    //Specify RequestPayLoad type in Header 
    httprequest.header("Content-Type","application/json");

    //Adding payload To request
    httprequest.body(requestparam.toJSONString());
    
    //Send the Responce 
    Response response = httprequest.request(Method.POST,"/register");
    String responcebody = response.getBody().asPrettyString();
    System.out.println("Responcebody :"+responcebody);
    
    System.out.println("status Code :"+response.statusCode());
    Assert.assertEquals(response.getStatusCode(), 200);
    
    String contentType =response.header("Content-Type");
    System.out.println("Content Type :"+contentType);
    String responceofHost= response.header("Host");
    System.out.println("Responce Of Host :"+responceofHost);
    
    //to print all Headers
    Headers allheaders= response.headers();
    for(Header header:allheaders) {
    	System.out.println(header.getName()+" "+header.getValue());
    }
}
}


