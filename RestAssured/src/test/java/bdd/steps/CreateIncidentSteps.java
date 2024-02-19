package bdd.steps;

import java.io.File;
import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentSteps {
	
	RequestSpecification inputRequest = null;
	Response response = null;
	
	@Given("Set the endpoint for ServiceNow Incident Management")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev180149.service-now.com/api/now/table/incident";
	}
	
	@And("Set the authentication for ServiceNow")
	public void setAuthType() {
		RestAssured.authentication = RestAssured.basic("admin", "Servicenow1@");
	}
	
	@And("Set the QueryParam for Create Incident Request")
	public void setQueryParam() {
		inputRequest = RestAssured.given().log().all();
		inputRequest.given()
		.log().all()
		.queryParam("sysparm_fields", "sys_id, number, category, description, short_description");
	}
	
	@Given("Set the QueryParam in the Request")
	public void queryParam(DataTable dataTable) {
		inputRequest = RestAssured.given().log().all();
		Map<String, String> asMap = dataTable.asMap();
		inputRequest.queryParams(asMap);
	}
	
	@And("Set the Content Type for Create Incident Request")
	public void setContentType() {
		inputRequest.contentType(ContentType.JSON);
		
	}
	
	@And("Set the Accept for Create Incident Request")
	public void setAccept() {
		inputRequest.accept(ContentType.JSON);
		
	}

	@And("Set the request body as 'CreateRequest.json' Create Incident Request")
	public void set_the_request_body_as_create_request_json_in_create_incident_request1() {
		File jsonInputFile = new File("./src/test/resources/CreateRequest.json");
		inputRequest.body(jsonInputFile);
	}
	
	@And("Set the request body as 'CreateRequestWithSoftware.json' Create Incident Request")
	public void set_the_request_body_as_create_request_json_in_create_incident_request2() {
		File jsonInputFile = new File("./src/test/resources/CreateRequest.json");
		inputRequest.body(jsonInputFile);
	}
	
	//@And("Set the request body as {string} in Create Incident Request")
	@And("Set the request body as {string} in Create Incident Request")
	public void setRequestBody(String fileName) {
		File jsonInputFile = new File("./src/test/resources/"+fileName);
		inputRequest.body(jsonInputFile);
	}
	
	@When("Send the POST request to ServiceNow Incident Management")
	public void setPostRequest() {
		response = inputRequest.when().post();
		response.then().log().all();
	}
	
	@When("Send the GET request to ServiceNow Incident Management")
	public void sendGetRequest() {
		response = inputRequest.when().get();
		response.then().log().all();
	}
	
	@Then("Validate the Status code as {int}")
	public void validateStatusCode(int code) {
		response.then().assertThat().statusCode(code);
	}
	
	@And("Validate the response that has number starts with INC")
	public void validateNumberInResponse() {
		response.then().assertThat().body("result.number", Matchers.containsString("INC"));
	}
	
	
}
