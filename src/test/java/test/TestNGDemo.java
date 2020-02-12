package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pages.GoogleSearchPageObjects;


public class TestNGDemo {
	private static WebDriver driver =  null; 

	@BeforeTest
	public void TestSetups() {	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
		driver =    new ChromeDriver();			
		System.out.println("launched chrome driver");
	}
	
	
	@Test
	public static void TestPageObjectMethod() {			
		//create an object for the 'GoogleSearchPageObjects' ObjectMethod class		
		GoogleSearchPageObjects SearchPage = new GoogleSearchPageObjects(driver);		
		// launch url
		driver.get("https://google.com");		
		SearchPage.SetTextIntoSearchBox("raghav pal");		
		System.out.println("entered text and  press Key ENTER 11");
		
	}	
	@Test
	public static void googleSearch() {				
		//create an object for the 'GoogleSearchPageObjects' ObjectMethod class		
				GoogleSearchPageObjects SearchPage = new GoogleSearchPageObjects(driver);		
				// launch url
				driver.get("https://google.com");		
				SearchPage.SetTextIntoSearchBox("automationstepbystep");		
				System.out.println("entered text and  press Key ENTER 22");
				
	}
	@AfterTest
	public void teardown() {
		driver.close();	 
		driver.quit();
		System.out.println("Done -TestNGDemo class");
	
	}
}
