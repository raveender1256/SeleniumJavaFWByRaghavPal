package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPageObjects;
//import pages.GoogleSearchPage;

public class TestNGDemo2 {
	private  static WebDriver driver =  null; 
	
	
	@BeforeTest
	public void TestSetups() {	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
		driver = new ChromeDriver();
	
		System.out.println("Launched chrome browser");
	}
	
	
	@Test
	public static void TestPageObjectMethod2() {			
		//create an object for the 'GoogleSearchPageObjects' ObjectMethod class		
		GoogleSearchPageObjects SearchPage = new GoogleSearchPageObjects(driver);		
		//launch url
		driver.get("https://google.com");		
		SearchPage.SetTextIntoSearchBox("raghav pal");		
		System.out.println("entered text and  press Key ENTER 33");
	
	}	
	
	
	@Test
	public static void googleSearch2() {				
		//create an object for the 'GoogleSearchPageObjects' ObjectMethod class		
		GoogleSearchPageObjects SearchPage = new GoogleSearchPageObjects(driver);		
		//launch url
		driver.get("https://google.com");		
		SearchPage.SetTextIntoSearchBox("automationstepbystep");		
		System.out.println("entered text and  press Key ENTER 44");
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();	 
		driver.quit();
		System.out.println("Done -TestNGDemo2 class");
	
	}
}
