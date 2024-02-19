package Chain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestWithMultiQueryParam extends BaseRestImpl{
	
	@Test(dependsOnMethods = "Chain.CreateRequestWithFile.SendPostRequest_incident")
	public void sendGetRequest_json_incident() {
		
		Map<String,String> allQueryParams = new HashMap<String,String>();
		allQueryParams.put("category", "software");
		allQueryParams.put("sysparm_fields", "sys_id, number, category");
		
		//Adding query parameter in the input Response using map
		Response response = inputRequest
								.given()
								.queryParams(allQueryParams)
								.accept(ContentType.JSON)
								
								.when()
								.get();
		
		
		List<String> allSys_Id = response.jsonPath().getList("result.sys_id");
		System.out.println("Sys_ID: " + allSys_Id);

	
	}
	
	//@Test
	public void sendGetRequest_xml_incident() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		/*
		 * //Adding query parameter in the input Response 
		 * response = RestAssured
		 * .given() 
		 * .queryParam("category", "software") 
		 * .queryParam("sysparm_fields", "number,sys_id,category") 
		 * .get();
		 */
		
		Map<String,String> allQueryParams = new HashMap<String,String>();
		allQueryParams.put("category", "software");
		allQueryParams.put("sysparm_fields", "sys_id, number, category");
		
		//Adding query parameter in the input Response using map
		Response response_xml = RestAssured
								.given()
								.queryParams(allQueryParams)
								.accept(ContentType.XML)
								
								.when()
								.get();
		
		response_xml.prettyPrint();
		System.out.println("Status code: " + response_xml.statusCode());
		

		

		List<String> allSys_Id = response_xml.xmlPath().getList("response.result.sys_id");
		System.out.println("First Sys_ID: " + response_xml.xmlPath().getString("response.result[0].sys_id"));
		System.out.println("Sys_ID: " + allSys_Id);

	
	}
	
	//@Test
	public void sendGetRequest_json_changeRequest() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		/*
		 * //Adding query parameter in the input Response 
		 * response = RestAssured
		 * .given() 
		 * .queryParam("category", "software") 
		 * .queryParam("sysparm_fields", "number,sys_id,category") 
		 * .get();
		 */
		
		Map<String,String> allQueryParams = new HashMap<String,String>();
		allQueryParams.put("category", "software");
		allQueryParams.put("sysparm_fields", "sys_id, number, category");
		
		//Adding query parameter in the input Response using map
		Response response_json = RestAssured
								.given()
								.queryParams(allQueryParams)
								.accept(ContentType.JSON)
								
								.when()
								.get();
		
		response_json.prettyPrint();
		System.out.println("Status code: " + response_json.statusCode());
		
		int size = response_json.jsonPath().getList("result").size();
		System.out.println("Size: " + size);
		
		List<String> allSys_Id = response_json.jsonPath().getList("result.sys_id");
		System.out.println("First Sys_ID: " + response_json.jsonPath().getString("result[0].sys_id"));

		
		System.out.println("Sys_ID: " + allSys_Id);
	
		}
	
}
