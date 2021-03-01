package test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class mainTest {
	static WebDriver driver;
	mainPagePOM mainP = new mainPagePOM(driver);
	
	
	
	@BeforeClass
	public static void initDriver() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	
	 @Test
	 public void test() throws IOException, InterruptedException {
		System.out.println("-----------------Test -----------------");
		System.out.println("-enter to www.google.com");
		
		driver.get("https://www.google.com/");		  
		mainP.searchAnItem("Michael Jordan");
		Thread.sleep(2000);
		mainP.checkValidation();		 
	 } 
  
  
	 @AfterClass
	 public static void tearDown() {
		driver.quit();
	 }
	
}
