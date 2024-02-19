package week3.day2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidationCreaterequest {
	@Test //No request body
	public void SendPostRequest_incident() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		Response postResponse = RestAssured
						.given()
						.contentType(ContentType.JSON) //Mandatory for Post and Put
						.accept(ContentType.JSON)
						.when()
						.post();
		
		System.out.println("Status Code: " + postResponse.statusCode());
		postResponse.prettyPrint();
		
		String sys_id = postResponse.jsonPath().get("result.sys_id");
		System.out.println("sys_id: " + sys_id);
		
		//response schema matches the file or not
		postResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema
				(new File("./src/main/resources/Schema_incident.json")));
		
		postResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema_incident.json"));

	}
	
	
	@Test //No request body
	public void SendPostRequest_change_request() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/change_request";
		
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		Response postResponse = RestAssured
						.given()
						.contentType(ContentType.JSON) //Mandatory for Post and Put
						.accept(ContentType.JSON)
						.when()
						.post();
		
		System.out.println("Status Code: " + postResponse.statusCode());
		postResponse.prettyPrint();
		
		String sys_id = postResponse.jsonPath().get("result.sys_id");
		System.out.println("sys_id: " + sys_id);
		
		//response schema matches the file or not
		postResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema
				(new File("./src/main/resources/Schema_changeRequest.json")));
		
		postResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema_changeRequest.json"));

	}
	
}
