package utils;

//Providing driver to all other files
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	// Declaring variables
	public String landingPageProductName;
	public int LandingPageProductIncremented;
	// Declaring objects
	// public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;

	public TestContextSetup() throws IOException {
		testBase = new TestBase(); // Use this object to get driver initialized in testBase object variable
		pageObjectManager = new PageObjectManager(testBase.webDriverManager()); // Creating pageObjectManager object
																				// with initialized driver
		genericUtils = new GenericUtils(testBase.webDriverManager()); // Sending driver to GenericUtils class
	}

}
/*
 * Dependency Injection(DI): Accessing driver/variables in multiple packages -
 * Global scope Dependency Injection format: PicoContainer, Spring Framework,
 * EJB It helps avoid creating objects in step definitions
 */