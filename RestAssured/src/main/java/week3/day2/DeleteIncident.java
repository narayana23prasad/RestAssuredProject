package week3.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident {

	@Test
	public void sendDeleteRequest_incident() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");

		Response delete_Response = RestAssured.when().delete("5b322eb747948210c517c67d826d43d3");
		
		System.out.println("Status code: " + delete_Response.statusCode());
		delete_Response.prettyPrint();
	}
	
	@Test
	public void sendDeleteRequest_changeRequest() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");

		Response delete_Response = RestAssured.when().delete("0198eaff47948210c517c67d826d43d5");
		
		System.out.println("Status code: " + delete_Response.statusCode());
		delete_Response = RestAssured.when().delete("0198eaff47948210c517c67d826d43d5");
		System.out.println("Status code: " + delete_Response.statusCode());
	}
}
