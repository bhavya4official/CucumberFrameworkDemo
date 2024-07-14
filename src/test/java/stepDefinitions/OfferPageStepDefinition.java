package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;
//Single responsibility Principle - loosely coupled classes - class/method should have dedicated functionality

public class OfferPageStepDefinition {
	String offerPageProductName;
	TestContextSetup testContextSetup;
	OfferPage offerPage;

	/*
	 * Dependency Injection(DI): Accessing driver/variables in multiple packages - Global scope
	 * Dependency Injection format: PicoContainer, Spring Framework, EJB
	 */
	public OfferPageStepDefinition(TestContextSetup testContextSetup) { //DI - Injecting TestContextSetup class in the constructor of stepDefinition file to get access of all objects from textContextSetup
		this.testContextSetup = testContextSetup;
		this.offerPage = testContextSetup.pageObjectManager.getOfferPage();
	}
	
	public void switchToOffersPage() {
		// If already on Offers page, then skip below steps
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		
		LandingPage landingPage = testContextSetup.pageObjectManager.landingPage;
		
		landingPage.topDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
	    
//	    Set<String> allWindows = testContextSetup.driver.getWindowHandles(); //Without using GenericUtils 
//	    Iterator<String> i1 = allWindows.iterator();
//	    String parentWindow = i1.next();
//	    String childWindow = i1.next();	    
//	    testContextSetup.driver.switchTo().window(childWindow);

	}
	
	
	@Then("^User searched with (.+) shortname in offers page$")
	public void user_searched_with_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {  
		//OfferPage offerPage = new OfferPage(testContextSetup.driver);
		
		switchToOffersPage();
	    offerPage.searchItem(shortName);
//	    Thread.sleep(2000);
	    offerPageProductName = offerPage.getProductName();
	    
	}
	@Then("Validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offer_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

}


