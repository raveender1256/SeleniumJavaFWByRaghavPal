package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;
//import pages.GoogleSearchPage;

public class GoogleSearchPageObject {
	private static WebDriver driver =  null; 	
	private static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {	
		
		TestPageObjectMethod();
	}
	

	
	public static void TestPageObjectMethod() {		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
		driver =    new ChromeDriver();	
		GoogleSearchPageObjects SearchPage = new GoogleSearchPageObjects(driver);
		
		// launch url
		driver.get("https://google.com");   	
		SearchPage.SetTextIntoSearchBox("raghav pal");
		System.out.println("entered text and  press Key ENTER");
		
		
		driver.close();	 
		System.out.println("test completed and browser closed successfully222");
	}	
}
