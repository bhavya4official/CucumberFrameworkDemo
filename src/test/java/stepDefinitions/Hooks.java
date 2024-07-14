package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

// Implement pre-conditions & post-conditions cleanup for tests
public class Hooks {
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
//	@After
//	public void afterScenario() throws IOException {
//		testContextSetup.testBase.webDriverManager().quit();
//	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException { //Creating object of cucumber class (Scenario) that hold all information about scenario (Pass, fail etc.)
		if(scenario.isFailed()) {
			WebDriver driver = testContextSetup.testBase.webDriverManager();
			//Screenshot
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Casting the driver into taking screenshot mode
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);	//Converting file to byte format using 'Apache common io' utility
			scenario.attach(fileContent, "image/png", "screenshot");	//Attaching screenshot to scenario So, Extent report can fetch it from scenario object
		}
	}

}
