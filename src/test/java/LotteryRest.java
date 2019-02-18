import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class LotteryRest {
	
	@BeforeTest
	public void beforeTest()
	{
		RestAssured.baseURI = "http://localhost:8080";
	}

	@Test()
	public void findLottery()
	{
		String body = "{\"lottoId\":5}";
		
		Response response = RestAssured.given()
				.header("APIKEY","ABCDE12345ABCDE")
				.header("Content-Type","application/json")
				.cookie("Cookie","true")
				.urlEncodingEnabled(false)
				.when()
				.body(body)
				.post("/lotto");
		
		response.then().assertThat().body("lotto.lottoId",equalTo(5));
				
		response.then().assertThat().body("lotto.winners[0].numbers",hasItems(34,23,5));
	}
	
	
}
	 
	