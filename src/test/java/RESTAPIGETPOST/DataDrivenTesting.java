package RESTAPIGETPOST;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTesting {
	@Test(dataProvider="UserData")
public void createUser(String userName, String userJob) {
	// Base Url
		RestAssured.baseURI="https://reqres.in/api";
	    RequestSpecification httprequest =RestAssured.given();
	    
	    // How to Add Request Payload 
	    JSONObject requestparam = new JSONObject();
	    requestparam.put("name","userName");
	    requestparam.put("job", "userJob");
	    
	    //Specify RequestPayLoad type in Header 
	    httprequest.header("Content-Type","application/json");

	    //Adding payload To request
	    httprequest.body(requestparam.toJSONString());
	    
	    //Send the Responce 
	    Response response = httprequest.request(Method.POST,"/users");
	    String responcebody = response.getBody().asPrettyString();
	    System.out.println("Responcebody :"+responcebody);
	    
	    System.out.println("status Code :"+response.statusCode());
        Assert.assertEquals(responcebody.contains(userName), true);
        Assert.assertEquals(responcebody.contains(userJob), true);

}
	@DataProvider(name = "UserData")
	Object[][] getUserData() {
		String[][] userData = { { "Pralash", "QA" }, { "Shrikant", "SDET" }, { "Pawan", "TestEngineer" } };
		return userData;
	}
	@DataProvider(name = "UserDataExcel")
	Object[][] getUserDataExcel() {
	String filepath =System.getProperty("user.dir")+"/src/test/java/Userdata.xlsx";
		return userDataExcel;
	}
}