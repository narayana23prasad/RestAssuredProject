package Chain;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutIncident extends BaseRestImpl{
	
	@Test(dependsOnMethods = "Chain.CreateRequestWithFile.SendPostRequest_incident")
	public void SendPutRequest1( ) {
		
		response = inputRequest
				.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.queryParam("sysparm_fields", "sys_id, number, category, description, short_description")
				.body("{\"category\":\"hardware\",\"short_description\":\"updated via put request\"}")
				.when()
				.put(global_sys_id);
		
					
	}
	
	//@Test
	public void SendPutRequest2WithLog( ) {
	
		Response put_Response = inputRequest
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
