package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleGetRequest {
	
	@Test
	public void sendGetRequest_incident() {
		//1. Requirement
		//https://dev180149.service-now.com/now/nav/ui/classic/params/target/%24restapi.do
		
		//2. Endpoint
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		
		//3. Add request
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		//4. Sending request
		Response response = RestAssured.get();
		
		//5. Validate response
		response.prettyPrint();
		System.out.println("Status code: " + response.statusCode());
	}
	
	
	@Test
	public void sendGetRequest_changeRequest() {
		//1. Requirement
		//https://dev180149.service-now.com/now/nav/ui/classic/params/target/%24restapi.do
		
		//2. Endpoint
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/change_request";
		
		//3. Add request
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		RestAssured
			.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON);
		
		//4. Sending request
		Response response = RestAssured.get();
		
		//5. Validate response
		response.prettyPrint();
		System.out.println("Status code: " + response.statusCode());
	}
	
}
