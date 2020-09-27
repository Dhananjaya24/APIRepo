package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public static RequestSpecification reqSpecDetails;
	ResponseSpecification respSpecDetails;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		RestAssured.useRelaxedHTTPSValidation();
		if(reqSpecDetails==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		reqSpecDetails=new RequestSpecBuilder().setBaseUri(getGlobalValues("BaseURI")).addQueryParam("key","qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return reqSpecDetails;
		}
		
		else
		{
			return reqSpecDetails;
		
		}
		
	}
	
	public ResponseSpecification responsepecification()
	{
		respSpecDetails=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return respSpecDetails;
	
	}
	
	public String getGlobalValues(String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Mani\\Documents\\CucumberWorkSpace\\CucumberFramework\\src\\test\\java\\Resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	
	}
	
	public String getJsonPath(Response resp, String key)
	{
		String res=resp.asString();
		JsonPath js= new JsonPath(res);
		String value=js.get(key).toString();
		return value;
	}
}
