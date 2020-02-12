package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class Test1_GoogleSearch {
	private static WebDriver driver =  null; 	
	private static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {	
		//googleSearch();	
		googleSearchPOM();
	}
	
	public static void googleSearch() {				
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);	
		//driver.get("https://selenium.dev");
		//driver.findElement(By.name("search")).sendKeys("selenium");				
		//driver.findElement(By.className("search-icon")).click();
		System.out.println("clicked on searchbttn");
		driver.close();	 
		System.out.println("test completed and browser closed successfully");	
	}
	
	public static void googleSearchPOM() {		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
		driver =    new ChromeDriver();
		driver.get("https://google.com");   	
		GoogleSearchPage.Textbox_Search(driver).sendKeys("selenium" + Keys.ENTER);	
		System.out.println("clicked on searchbttn22");
		driver.close();	 
		System.out.println("test completed and browser closed successfully222");
	}	
}
