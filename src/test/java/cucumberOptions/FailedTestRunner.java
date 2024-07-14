package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@target/failed_scenarios.txt",
		glue="stepDefinitions",
		monochrome=true,
		plugin={"pretty", 
				"html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags="@PlaceOrder or @OffersPage"
		)

public class FailedTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() { //Wrapping below code in scenario method
		return super.scenarios();  //Super - Calling method from parent class
	}
	
}
