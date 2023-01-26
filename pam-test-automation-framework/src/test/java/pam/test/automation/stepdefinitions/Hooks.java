package pam.test.automation.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pam.test.automation.TestContext;
import pam.test.automation.managers.BrowserManager;
import pam.test.automation.managers.ConfigManager;

public class Hooks {
	WebDriver driver;

	@Before
	public void setup() {
		// Manage browser.
		// The default browser is Chrome, so it will be used if no browser parameter is provided.
		String browserName = System.getProperty("browser", "chrome");
		driver = BrowserManager.INSTANCE.getBrowser(browserName);

		TestContext.INSTANCE.setContext("webDriver", driver);

		// Manage configurations.
		// The default license is com, so it will be used if no license parameter is provided.
		String license = System.getProperty("license", "com");
		String url = ConfigManager.INSTANCE.getProperty(license);
		TestContext.INSTANCE.setContext("url", url);
	}

	@After
	public void tearDown() {
		driver = TestContext.INSTANCE.getContext("webDriver");
		driver.quit();
		TestContext.INSTANCE.clearData();
	}

}
