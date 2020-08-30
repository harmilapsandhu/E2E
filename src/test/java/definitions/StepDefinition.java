package definitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import pageObjects.PortalHome;
import resources.Base;

public class StepDefinition extends Base{
	@Given("Initialize the browser with Chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("Navigate to {string}")
	public void navigate_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(string);
	}
	@Given("Click on LogIn to enter secure LogIn page")
	public void click_on_log_in_to_enter_secure_log_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage la = new LandingPage(driver);
		la.getLogIn();
		}
	
	/*@When("User enters {string} and {string} and clicks Log In")
	public void user_enters_and_and_clicks_log_in(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    LogInPage lo = new LogInPage(driver);
	    lo.email().sendKeys(string);
	    lo.password().sendKeys(string2);
	    lo.LogIn().click();
	    //driver.switchTo().alert().accept();  //Accept pop-up
	    }*/
	@When("^User enters (.+) and (.+) and clicks Log In$")  //Use this syntax for parameterization (the one given by eclipse console doesn't work)
	public void user_enters_and_and_clicks_log_in(String username, String password) {
		 LogInPage lo = new LogInPage(driver);
		 lo.email().sendKeys(username);
		 lo.password().sendKeys(password);
		 lo.LogIn().click();
	}
	
	@SuppressWarnings("deprecation")
	@Then("Verify that the user is successfully logged in")
	public void verify_that_the_user_is_successfully_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    // PortalHome ph = new PortalHome(driver);
	    // Assert.assertTrue(ph.getSeach().isDisplayed());
	    System.out.println("Logged In");
	}
	
	
}