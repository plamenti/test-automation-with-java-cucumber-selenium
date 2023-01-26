package pam.test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class HomePage {
	private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);
	private static final int ELEMENT_WAIT_TIME = 4;

	private WebDriver driver;
	private By loginButtonBy =  By.id("loginButton2");
	private By usernameBy = By.id("psramusernamepopup");
	private By passwordBy = By.xpath("//div[@class='form-group']//input[@name='password']");
	private By formLoginButtonBy = By.xpath("//section//button[@type='submit']");
	private By verifyMyAccountPopupBy = By.xpath("//section/span[text()='Verify My Account']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo(String url) {
//		String url = "https://ram.qa.pyr/";
		LOG.info("Navigate to: {}", url);
		this.driver.get(url);
	}

	public void openLoginForm() {
		WebElement button = customWaitForElement(ELEMENT_WAIT_TIME, loginButtonBy);
		button.click();
	}

	public void enterUsername(String value) {
		WebElement usernameField = customWaitForElement(ELEMENT_WAIT_TIME, usernameBy);
		customSendKeys(usernameField, value);
	}

	public void enterPassword(String value) {
		WebElement passwordField = customWaitForElement(ELEMENT_WAIT_TIME, passwordBy);
		customSendKeys(passwordField, value);
	}

	public void submitLoginForm() {
		WebElement formLoginButton = customWaitForElement(ELEMENT_WAIT_TIME, formLoginButtonBy);
		formLoginButton.click();
	}

	public boolean userIsSuccessfullyLoggedIn() {
		WebElement verifyMyAccountPopup = customWaitForElement(ELEMENT_WAIT_TIME, verifyMyAccountPopupBy);
		return verifyMyAccountPopup.isDisplayed();
	}

	private WebElement customWaitForElement(int seconds, By findStrategy) {
		LOG.info("Waiting for element found: {}", findStrategy);
		return new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(driver -> driver.findElement(findStrategy));
	}

	private void customSendKeys(WebElement field, String value) {
		field.clear();
		field.sendKeys(value);
	}
}
