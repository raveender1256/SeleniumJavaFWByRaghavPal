package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;
import demo.Log4jDemo;
import pages.GoogleSearchPageObjects;


public class ExtentReportsTestNGDemo {


	public static WebDriver driver =  null; 
	public static ExtentHtmlReporter htmlReports = null;
	public static ExtentReports extent = null;
	public static ExtentTest Testlog  = null;

	static Logger logger = LogManager.getLogger(ExtentReportsTestNGDemo.class.getName());
	static String projectPath = System.getProperty("user.dir");

	public static String BrowserName = null;

	@BeforeSuite
	public void BeforeSuiteSetups() {	
		htmlReports = new ExtentHtmlReporter("htmlReports.html");		
		extent = new ExtentReports();
		extent.attachReporter(htmlReports);	
	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void TestSetups() {	
		PropertiesFile.getProperties();
		if(BrowserName.equalsIgnoreCase("chrome")) {
			//chrome driver
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
			driver =    new ChromeDriver();				
			driver.manage().window().maximize();
			logger.info("launched chrome driver- test log4j 1");
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{	
			System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver\\geckodriver.exe");						
	
			try {
				System.out.println("entered Try block");
				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(new FirefoxProfile());			
				options.setCapability("marionette", false);
				driver = new FirefoxDriver(options);
			} catch (Exception ex) {
				System.out.println("entered catch block");
				System.out.println(ex.getMessage());
				System.out.println(ex.getCause());
				ex.printStackTrace();
			}

			driver.manage().window().maximize();
			logger.info("launched gecko Firefox driver- test log4j 1");
		}
	}


	@Test
	public void TestPageObjectMethod() {		
		Testlog = extent.createTest("TestPageObjectMethod");
		//create an object for the 'GoogleSearchPageObjects' ObjectMethod class		
		GoogleSearchPageObjects SearchPage = new GoogleSearchPageObjects(driver);		
		// launch url
		driver.get("https://google.com");		
		Testlog.log(Status.INFO, " Launched URL  ");		
		Testlog.pass("Launched URL successfully");
		SearchPage.SetTextIntoSearchBox("raghav pal");		
		System.out.println();
		Testlog.info("entered text and  press Key ENTER 11");		
		Testlog.pass( "searched the text1 successfully");
		logger.info("test log4j 2");
	}	

	@Test
	public void googleSearchMethod()  {		

		try {
			Testlog = extent.createTest("googleSearchMethod");
			//create an object for the 'GoogleSearchPageObjects' ObjectMethod class		
			GoogleSearchPageObjects SearchPage = new GoogleSearchPageObjects(driver);		
			// launch url
			driver.get("https://google.com");		
			Testlog.log(Status.INFO, " Launched URL ");		
			Testlog.log(Status.PASS, "Launched URL successfully");
			SearchPage.SetTextIntoSearchBox("automationstepbystep");						
			Testlog.log(Status.INFO,  "entered text and  press Key ENTER 22");	
			Testlog.fail("searching the text2 failed",
					MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			Testlog.fail("searching the text2 failed").addScreenCaptureFromPath("screenshot.png");
			logger.info("test log4j 3");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}	
	}

	@AfterTest
	public void teardown() {
		driver.close();	 
		driver.quit();	
		Testlog.log(Status.INFO, " closed and Quit the browser ");		
		logger.info(" closed and Quit the browser  test log4j 4");
		PropertiesFile.setProperties();
	}

	@AfterSuite
	public void AfterSuite() {			
		Testlog.log(Status.PASS, "Done -TestNGDemo class");
		extent.flush();
		logger.info(" Done -TestNGDemo class  test log4j 5");
	}




}
