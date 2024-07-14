package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By product = By.cssSelector("p.product-name");
	By quantity = By.cssSelector(".quantity");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
	
	public String getProductName() {
		return driver.findElement(product).getText();
	}
	public String getProductQuantity() {
		return driver.findElement(quantity).getCssValue("value");
//		return Integer.parseInt(quantity);
	}
	public boolean verifyPromoBtn() {
		return driver.findElement(promoButton).isDisplayed();
	}
	public boolean verifyPlaceOrderBtn() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	public void applyPromoCode() {
		driver.findElement(promoButton).click();
	}
	public void placeOrderButton() {
		driver.findElement(placeOrderButton).click();
	}

}
