 package POSTRequestPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestDummyAPI {
	@Test
	public void getListOfEmployees() {
		// Base Uri

		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		//Request object 

		RequestSpecification httprequest= RestAssured.given();
		Response response = httprequest.request(Method.GET,"/employees");

		String responsebody = response.getBody().asPrettyString();
		System.out.println("Response Body "+responsebody);

		// Validating Stroing in Response Body 

		Assert.assertEquals(true, responsebody.contains("Brielle Williamson"));

		JsonPath jpath = response.jsonPath();

		// validating data at json Node 
		System.out.println(jpath.getString("x.data[5].employee_name"));
	}
}
//http://dummy.restapiexample.com/api/v1/employees
