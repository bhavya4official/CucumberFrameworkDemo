package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	public WebDriver driver;
	
	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	public void getSearchText() {
		driver.findElement(search).getText();
	}
	public String getProductName() {
		return driver.findElement(productName).getText();
	}

}
