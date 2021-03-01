package test;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class mainPagePOM {
	WebDriver driver;
		
	
	By searchInputField = By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input");
	By searchTableResult = By.xpath("//*[@id=\"rso\"]/div/div");	
	By totalResults = By.id("result-stats");
	
	
	
    public mainPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}	
	
	
	public void searchAnItem(String itemName) {
		System.out.println("-search for '"+itemName+"'");
		driver.findElement(searchInputField).sendKeys(itemName);
		driver.findElement(searchInputField).sendKeys(Keys.ENTER);		
	}
	
	
	public void checkValidation() {
		List<WebElement> list = driver.findElements(searchTableResult);	
		System.out.println("-verifing the search page should contain minimum 1 row");
		Assert.assertTrue("Verification Failed: The search page must contain minimum 1 row: "  ,list.size()>1);	
		System.out.println("-verifing the total search results should be at least 1.000.000");
		Assert.assertTrue("Verification Failed: The total search results should be at least 1.000.000: "  ,driver.findElement(totalResults).getText().contains(",000,000"));	
	
	}
}
