import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataForTests {

	
	@DataProvider(name="DataForPost")
	public Object[][] dataForPost() {
//		Object[][] data = new Object[2][3];
//		data[0][0] = "Albert";
//		data[0][1] = "Einstein";
//		data[0][2] = 2;
//		data[1][0] = "Thomas";
//		data[1][1] = "Edison";
//		data[1][2] = 2;
//		return data;
		
		return new Object[][] {
			{"Graham","Bell",1},
			{"Henry","Ford",2}
		};
	}
	
	
	@DataProvider(name="DeleteDAta")
	public Object[] dataForDelete() {
		return new Object[] {
			4,5,6,7	
		};
	}
	
}
