package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentEmailReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicsDemo {
	
	private static WebDriver driver = null;
	private static String projectPath = System.getProperty("user.dir");

	
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReports = new ExtentHtmlReporter("htmlReports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReports);
		
		 
	
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");		
		
		
		ExtentTest test1 = extent.createTest("Test one");
			
		driver = new ChromeDriver();	
		test1.log(Status.INFO, " initiated the Webdriver and assigned to Chrome driver ");	
		driver.get("https://google.com");
		test1.log(Status.INFO, " Launched URL ");		
		test1.log(Status.PASS, "Launched URL successfully");
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);	
		test1.log(Status.PASS, " Entered Text in search field and hit Enter ");		
		
		
		driver.close();	 
		//System.out.println("test completed and browser closed successfully");	
		test1.log(Status.INFO, " closing the browser ");
		driver.quit();	 
		test1.log(Status.INFO, " Quitting the browser ");
		test1.log(Status.PASS, "Googlesearch Method1 run successfully");
		
		
		
		
		
		//test2
		
		ExtentTest test2 = extent.createTest("Test Two");
		//System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
		driver = new ChromeDriver();	
		
		
		test2.log(Status.INFO, " initiated the Webdriver and assigned to Chrome driver ");	
		driver.get("https://google.com");
		test2.log(Status.INFO, " Launched URL ");		
		test2.log(Status.FAIL, "Launched URL successfully");
		driver.findElement(By.name("q")).sendKeys("Raghav pal" + Keys.ENTER);	
		test2.log(Status.PASS, " Entered Text in search field and hit Enter ");		
		
		
		driver.close();	 
		//System.out.println("test completed and browser closed successfully");	
		test2.log(Status.INFO, " closing the browser ");		
		driver.quit();	 
		test2.log(Status.INFO, " Quitting the browser ");
		
		test2.log(Status.PASS, "Googlesearch Method2 run successfully");
		
		extent.flush();
		 
	}
}
