package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) { //Instantiating TestContextSetup class to get its properties & call its constructor So there will be no need of creating any object in this file
		this.testContextSetup = testContextSetup; //testContextSetup object is created in above parameter
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage(); //Accessing LandingPage object Using PageObjectManager
	}
	
	@Given("User is on GreenCard Landing page")
	public void user_is_on_green_card_landing_page() throws IOException {    
		//System.setProperty("webdriver.chrome.driver", "/Users/Bhavya/documents/chromedriver");
//		testContextSetup.driver = new ChromeDriver(); //Driver object initialization without Test Utilities
//		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName); //Without using PageObject model
		
		//LandingPage landingPage = new LandingPage(testContextSetup.driver); //Without using PageObjectManager 
		//landingPage.searchItem(shortName);
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
	    testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
	    
	    System.out.println(testContextSetup.landingPageProductName+" is extracted from Home page.");
	    
	}
	
	@When("Added {string} items of selected product to cart")
	public void add_n_product_to_cart(String quantity) {
			landingPage.increaseQuantity(Integer.parseInt(quantity));
			
			testContextSetup.LandingPageProductIncremented = Integer.parseInt(quantity);
			landingPage.addToCart();
	}

}
