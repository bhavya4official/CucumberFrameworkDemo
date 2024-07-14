package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) { //automatically invoked with driver details when LandingPage object is created (class instantiated) in POManager
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By incQuantityBtn = By.cssSelector("a.increment");
	By addToCartBtn = By.cssSelector(".product-action button");
	By topDeals = By.linkText("Top Deals");
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkoutButton = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	public void getSearchText() {
		driver.findElement(search).getText();
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	public void topDealsPage() {
		driver.findElement(topDeals).click();
	}
	public void increaseQuantity(int quantity) {
		int i = quantity;
		while(i>1) {
			driver.findElement(incQuantityBtn).click();
			i--;
		}
	}
	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}
	public void checkoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	public String getTitleLandingPage() {
		return driver.getTitle();
	}

}
