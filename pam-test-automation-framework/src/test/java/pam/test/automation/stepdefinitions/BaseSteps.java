package pam.test.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import pam.test.automation.TestContext;

public abstract class BaseSteps {

	protected WebDriver getDriver() {
		return TestContext.INSTANCE.getContext("webDriver");
	}

	protected String getUrl() {
		return TestContext.INSTANCE.getContext("url");
	}
}
