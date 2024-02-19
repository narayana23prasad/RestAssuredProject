package week3.day2;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnAssertions {
	@Test
	public void sendGetRequest_incident1() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
		Response response = RestAssured.get();
		response.prettyPrint();
		//Then converts response to validatable response
		//assert the status code 
		response.then().assertThat().statusCode(200);

	}
	
	@Test
	public void sendGetRequest_incident2() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
		
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
		//Then converts response to validatable response
		//assert the status code 
		response_json.then().assertThat().statusCode(200);
		//index known and value partially know -> containsString
		response_json.then().body("result[0].number", Matchers.containsString("INC"));
		
		//index not known and value fully known -> hasItem
		response_json.then().body("result.number", Matchers.hasItem("INC0000027"));
		
		//index known and value know -> equalTo
		response_json.then().body("result[0].number", Matchers.equalTo("INC0000006"));
		
		response_json.prettyPrint();

	}
}
