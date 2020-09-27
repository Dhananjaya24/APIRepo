package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import POJOS.LocationPOJO;
import Resources.APIEndpointResources;
import Resources.TestdataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddPlace extends Utils {
	
	TestdataBuild data = new TestdataBuild ();

	//ResponseSpecification respSpecDetails;
	RequestSpecification reqResponse;
	Response resp;
	static String placeId;
	
	
	
	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
	    
		//RestAssured.useRelaxedHTTPSValidation();
		//reqCommonParams=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		//		.addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
		//respSpecDetails=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		//reuest specication details fall into reuestSpecification method
		//Add location payload will be called with values and we will have complete add payload data back
		reqResponse=given().spec(requestSpecification()).body(data.addLocationPayload(name, language, address));
		
		//resp=reqResponse.when().post("maps/api/place/add/json")
			//	.then().spec(respSpecDetails).extract().response();
		
		//String res=resp.asString();
		//System.out.println(res);
	    
	}


	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String APIEndpoint, String method) {
		
		//Constructor of enum class will be called with value of API end point
		APIEndpointResources apiEndpoint=APIEndpointResources.valueOf(APIEndpoint);
		System.out.println("Enum api endpoint check: "+apiEndpoint.getAPIResource());
		
		if(method.equalsIgnoreCase("POST"))
		{
		resp=reqResponse.when().post(apiEndpoint.getAPIResource())
				.then().spec(responsepecification()).extract().response();
		}
		
		else if(method.equalsIgnoreCase("GET"))
		{
			resp=reqResponse.when().get(apiEndpoint.getAPIResource())
					.then().spec(responsepecification()).extract().response();
		}
	    
	}
	@Then("Then API call should give reponse status code {int}")
	public void then_api_call_should_give_reponse_status_code(Integer int1) {
		
		System.out.println("Status code check:"+resp.getStatusCode());		
		assertEquals(resp.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
		
		//String res=resp.asString();
		//System.out.println(res);
		//JsonPath js= new JsonPath(res);
		assertEquals(getJsonPath(resp,key),expectedValue);
		//System.out.println("Key value verification:"+js.get(key));	    
		System.out.println("Key value verification:"+getJsonPath(resp,key));
	}
	
	@Then("Verify created place_id maps to {string} using {string}")
	public void verify_created_place_id_maps_to_using(String expName, String APIEndpoint) throws IOException {
	 
		placeId=getJsonPath(resp,"place_id");
		System.out.println("Place id verification"+placeId);
		reqResponse=given().spec(requestSpecification()).queryParam("place_id", placeId);
		
		user_calls_with_post_http_request(APIEndpoint, "GET");
		
		String name= getJsonPath(resp,"name");
		assertEquals(getJsonPath(resp,"name"),expName);
		System.out.println("name  verification"+name);	
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		
		reqResponse=given().spec(requestSpecification()).body(data.deletePlacePayload(placeId));
				
			/*	("{\r\n" + 
				"    \"place_id\": \"87gdugdg\"\r\n" + 
				"}"    */
	}

}
