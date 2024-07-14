package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

//Generic Test Utilities - Reusable utilities (eg: explicit wait, parse string)
//Whoever wants to use these generic methods can create object of GenericUtils class & send driver as argument
public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) { //Catch driver from where its object is created - TestContextSetup
		this.driver = driver;
	}
	
	public void switchWindowToChild() { // using public driver from top
		Set<String> allWindows = driver.getWindowHandles();
	    Iterator<String> i1 = allWindows.iterator();
	    String parentWindow = i1.next();
	    String childWindow = i1.next();	    
	    driver.switchTo().window(childWindow);
	}
}
