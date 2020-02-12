package HeadlessChrome;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HeadlessChromeDemo {
	
	static String projectPath  = System.getProperty("user.dir");
	WebDriver driver = null;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void TestSetups(String browserName)  throws Exception {	
		//browserName = "chrome" ;
		
		System.out.println("Browser Name is  "+  browserName);
		System.out.println("Thread id is :"+Thread.currentThread().getId());
		System.out.println("Thread name is :"+Thread.currentThread().getName());
		
		if(browserName.equalsIgnoreCase("chrome")) {		
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");	
			
			ChromeOptions Options = new ChromeOptions();
			Options.addArguments("Headless");
			
			driver =    new ChromeDriver(Options);				
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver\\geckodriver.exe");
			driver =    new FirefoxDriver();				
			driver.manage().window().maximize();
		
		}else if(browserName.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", projectPath+"\\Drivers\\IEDriver\\IEDriverServer.exe");
			driver =    new InternetExplorerDriver();				
			driver.manage().window().maximize();
			
		}else if (browserName==null||browserName.isEmpty()){
			System.out.println("browserName is empty or null .. pls enter some any browserName");			
		}			
	}
	@Test
	public void HeadlessChrome01() throws Exception {	
		
		driver.get("https://google.com");		
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("testNG.doc"+Keys.RETURN);
		Thread.sleep(3000);		
		
		System.out.println(driver.getTitle());
		
		System.out.println("Test completed");
	}
	
	@AfterTest
     public void teardown() {
    	 driver.close();
    	 System.out.println("Close the current window, quitting the browser if it's the last window currently open.");
    	 driver.quit();
    	 System.out.println("Quits this driver, closing every associated window.");
     }
	
}
