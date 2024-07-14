package pageObjects;

import org.openqa.selenium.WebDriver;

//Factory Design Pattern - Separate file (Single java class) responsible for creating objects of all page-object java pages

public class PageObjectManager {
	
	public LandingPage landingPage;
	public OfferPage offerPage;
	public WebDriver driver; // sharing this driver to object pages
	
	public PageObjectManager(WebDriver driver) { // This driver will come from class (TestContextSetup) where we are calling this PageObjectManager 
		this.driver = driver; //Expecting driver to get initialize
	} //It will take driver from webDriverManager (testBase) & delegate the driver to individual page objects
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver); //Storing the driver object of LandingPage in variable 
		return landingPage;
	}
	public OfferPage getOfferPage() {
		//return offerPage = new OfferPage(driver);
		return new OfferPage(driver);
	}
	public CheckoutPage getCheckoutPage() {
		return new CheckoutPage(driver);
	}

}
