package RESTAPIGETPOST;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestPractice {
@Test
public void GetListOfUsers() {
// Base URI
RestAssured.baseURI= "https://reqres.in/api/users";

//Request Object 
RequestSpecification httprequest= RestAssured.given(); //http Request used to send Resquest
Response responce =httprequest.request(Method.GET,"?page=2");

//How to print Resonce BODY
String responcebody= responce.getBody().asPrettyString();
System.out.println("Responce Body :"+responcebody);

// How To read and Print Status code
int statuscode = responce.getStatusCode();
System.out.println("Status Code "+statuscode);

//how to print Status Lime
String statusline =   responce.getStatusLine();
System.out.println("StatusLine :"+statusline);

Assert.assertEquals("HTTP/1.1 200 OK" ,statusline );
Assert.assertEquals(statuscode, 200);
   }
}
