package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class checkoutStepDefinition {

	int CheckoutPageProductQuantity;
	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;
	LandingPage landingPage;
	
	public checkoutStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
//	@Given("User is on GreenCard Landing page")
//	public void user_is_on_green_card_landing_page() {
//		
//	}
//	@When("^User searched with shortname (.+) and extracted actual name of product$")
//	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
//		testContextSetup.pageObjectManager.getLandingPage().getProductName().split("-")[0].trim();
//	}
	
	@Then("^User proceeds to checkout and validate the (.+) item in checkout page$") 
	public void validate_product_name_in_checkout_page(String productName) throws InterruptedException {
		landingPage.checkoutItems();
//		Assert.assertEquals(productName, checkoutPage.getProductName());
		Thread.sleep(2000);
	}
//	@Then("Verify the quantity of product added") 
//	public void validate_the_quantity_of_product_added() {
//		CheckoutPageProductQuantity = Integer.parseInt(checkoutPage.getProductQuantity());
//		Assert.assertEquals(testContextSetup.LandingPageProductIncremented, CheckoutPageProductQuantity);
//	}
	@Then("Verify user have ablitiy to enter promo code and place the order")
	public void verify_user_have_ability_enter_promo_code() {
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
	}

}
