package Cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/Features",plugin="json:target/jsonReports/finalReport.json", glue={"StepDefination"})//To run all the test cases of package
//@CucumberOptions(features="src/test/java/Features", glue="StepDefination.Login.feature")//To run all the test cases of a file in a package
	public class TestRunner {
	
	//tags="@AddPlace"

}
