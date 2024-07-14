package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Generic test utilities and pass driver in constructor from Context file
public class TestBase {
	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException { //This method is responsible to give driver object initialization to TestContextSetup
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties"); //Predefined java class to Convert file to input stream object
		//System.getProperties() - get project path at run time - machine independent execution
		//user.dir - current working directory
		System.out.println("> User dir= "+ System.getProperty("user.dir")+" fis= "+fis); //Debug System.getProperty("user.dir")+"//src//test//resources//global.properties"
		Properties prop = new Properties(); //Predefined java class have ability to read properties files
		prop.load(fis);
		
		String url = prop.getProperty("QAURL");

		
		String browser_properties = prop.getProperty("Browser");
		String browser_maven = System.getProperty("Browser");
		//result = testCondition ? value1 : value2
		
		String browser = browser_maven!=null ? browser_maven : browser_properties; 
		
		System.out.println(">URL= "+url+"Property browser= "+prop.getProperty("Browser")+" Selected browser= "+browser);
		
		if(driver == null) { //Driver will be initialize only once
			if(browser.equalsIgnoreCase("Chrome")) {
//				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//src//test//resources//chromedriver");
				driver = new ChromeDriver(); //Driver object initialization			
			}
			if(browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C://Users//Bhavya Singh//Documents//Eclipse//CucumberFramework//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("> created driver ="+driver);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
			driver.get(url);
			
		}
		return driver; 
	}

}


// Driver travel: webDriverManager() -> testContextSetup() -> PageObjectManager() -> LandingPage()