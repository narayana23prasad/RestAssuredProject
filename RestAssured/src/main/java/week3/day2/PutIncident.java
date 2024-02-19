package week3.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutIncident {
	
	//@Test
	public void SendPutRequest1( ) {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		Response put_Response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
		.body("{\"category\":\"hardware\",\"short_description\":\"updated via put request\"}")
		.when()
		.put("5b322eb747948210c517c67d826d43d3");
		
		System.out.println("Status code:" + put_Response.statusCode());
		put_Response.prettyPrint();
					
	}
	
	@Test
	public void SendPutRequest2WithLog( ) {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		Response put_Response = RestAssured
								.given()
								.log().all()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
								.body("{\"category\":\"hardware\",\"short_description\":\"updated via put request\"}")
								.when()
								.put("5b322eb747948210c517c67d826d43d3");
				
		System.out.println("Status code:" + put_Response.statusCode());
		//put_Response.prettyPrint();
					
	}
}
