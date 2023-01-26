package pam.test.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pam.test.automation.pages.HomePage;

public class LoginSteps extends BaseSteps {
	HomePage homePage;

	@Given("home page is open")
	public void homePageIsOpen() {
		homePage = new HomePage(getDriver());
		homePage.goTo(getUrl());
	}

	@When("user selects to login")
	public void userSelectsToLogin() {
		homePage.openLoginForm();
	}

	@When("provide valid credentials")
	public void provideValidCredentials() {
		homePage.enterUsername("av_com_001");
		homePage.enterPassword("MyTest123");
		homePage.submitLoginForm();
	}

	@Then("user is successfully logged in")
	public void userIsSuccessfullyLoggedIn() {
		Assert.assertTrue(homePage.userIsSuccessfullyLoggedIn(), "User is not logged in!");
	}

	@When("provide invalid credentials")
	public void provideInvalidCredentials() {
		homePage.enterUsername("non_existing_user");
		homePage.enterPassword("wrong_pass");
		homePage.submitLoginForm();
	}

}
