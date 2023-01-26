package pam.test.automation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		plugin = {
				"json:build/cucumber/cucumber-report.json"
		},
		glue = "pam/test/automation/stepdefinitions",
		features = "src/test/resources/features",
		snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
