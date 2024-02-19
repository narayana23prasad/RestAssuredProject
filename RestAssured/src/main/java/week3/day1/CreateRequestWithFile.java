package week3.day1;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateRequestWithFile {
	
	@Test //No request body
	public void SendPostRequest_incident() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		File jsonInputFile = new File("./src/main/resources/CreateRequest.json");
		
		Response postResponse = RestAssured
						.given()
						.contentType(ContentType.JSON) //Mandatory for Post and Put
						.accept(ContentType.JSON)
						.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
						.body(jsonInputFile)
						.when()
						.post();
		
		System.out.println("Status Code: " + postResponse.statusCode());
		postResponse.prettyPrint();
		
		String sys_id = postResponse.jsonPath().get("result.sys_id");
		System.out.println("sys_id: " + sys_id);
		
	}
	
	@Test //No request body
	public void SendPostRequest_changeRequest() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		File jsonInputFile = new File("./src/main/resources/CreateRequest.json");
		
		Response postResponse = RestAssured
						.given()
						.contentType(ContentType.JSON) //Mandatory for Post and Put
						.accept(ContentType.XML)
						.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
						.body(jsonInputFile)
						.when()
						.post();
		
		System.out.println("Status Code: " + postResponse.statusCode());
		postResponse.prettyPrint();
		
		String sys_id = postResponse.xmlPath().get("response.result.sys_id");
		System.out.println("sys_id: " + sys_id);
		
	}
}
