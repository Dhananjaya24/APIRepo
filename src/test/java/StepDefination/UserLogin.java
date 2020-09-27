package StepDefination;



import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;





public class UserLogin {
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Code to open login page");
	}

	@When("user logins into application with {string} and {string}")
	public void user_logins_into_application_with_and(String string, String string2) {
		System.out.println("User details");
    	System.out.println(string);
    	System.out.println(string2);
	}
	
	@Then("User logged in homepage should display")
	public void user_logged_in_homepage_should_display() {
		System.out.println("User logged in home page should display");
	}
	@Then("logged in user name display {string}")
	public void logged_in_user_name_display(String string) {
		System.out.println("Loggedin user homepage is displaying");
    	System.out.println(string);
	}

	
	}
