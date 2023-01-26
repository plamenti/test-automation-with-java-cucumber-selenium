package pam.test.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

	@When("user selects to register")
	public void userSelectsToRegister() {
		System.out.println("user selects to register");
	}

	@Then("registration form is open")
	public void registrationFormIsOpen() {
		System.out.println("registration form is open");
	}
}
