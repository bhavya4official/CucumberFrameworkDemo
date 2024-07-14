package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefinitions",
		monochrome=true,
		plugin={"pretty", 
				"html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"},
		tags="@PlaceOrder or @OffersPage"
		)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() { //Wrapping below code in scenario method
		return super.scenarios();  //Super - Calling method from parent class
	}
	
}

/***
Executing using Eclipse Maven Plugin
	Right click on project > Run As > Run Configuration
	Select Maven Build > New
	Select project path in 'Base Directory' & type 'test -Dcucumber.filter.tags="@PlaceOrder"' in Goals & click Run
***/


/***
Executing using CLI:
	ProjectPath\mvn test
	Using Command Line Options:
		>mvn test -D cucumber.filter.tags="@PlaceOrder"
		
Reference website: https://cucumber.io/docs/cucumber/api/?lang=java#options
***/