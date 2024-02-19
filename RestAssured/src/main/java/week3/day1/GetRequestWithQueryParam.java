package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestWithQueryParam {
	
	@Test
	public void sendGetRequest() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		//Adding query parameter in the input
		Response response = RestAssured.given().queryParam("category", "software").get();
		
		response.prettyPrint();
		System.out.println("Status code: " + response.statusCode());
	}
	
}
