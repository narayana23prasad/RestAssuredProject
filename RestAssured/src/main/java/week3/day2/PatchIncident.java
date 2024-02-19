package week3.day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchIncident {
	
	@Test
	public void SendPatchRequestString_incident( ) {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		Response patch_Response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
		.body("{\"category\":\"inquiry\",\"short_description\":\"updated via patch request\"}")
		.when()
		.patch("5b322eb747948210c517c67d826d43d3");
		
		System.out.println("Status code:" + patch_Response.statusCode());
		patch_Response.prettyPrint();
					
	}
	
	@Test
	public void SendPatchRequestFile_incident( ) {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		File update_Json = new File("./src/main/resources/UpdateRequest.json");
		
		Response patch_Response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
		.body(update_Json)
		.when()
		.patch("5b322eb747948210c517c67d826d43d3");
		
		System.out.println("Status code:" + patch_Response.statusCode());
		patch_Response.prettyPrint();
					
	}
	
	@Test
	public void SendPatchRequestString_changeRequest( ) {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		Response patch_Response = RestAssured.given()
		.contentType(ContentType.XML)
		.accept(ContentType.XML)
		.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
		.body("<request>"
				+ "<entry>"
				+ "<description>updated via patch request</description>"
				+ "<category>inquiry</category>"
				+ "</entry>"
				+ "</request>")
		.when()
		.patch("0198eaff47948210c517c67d826d43d5");
		
		System.out.println("Status code:" + patch_Response.statusCode());
		patch_Response.prettyPrint();
					
	}
}
