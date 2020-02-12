package listeners;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.ExcelUtils;
import config.PropertiesFile;
import junit.framework.Assert;


// -- @Listeners(listeners.TestNGListeners.class)
public class TestNGFeaturesDemo {
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * String excelPath = System.getProperty("user.dir")+"/Excel/testdata1.xlsx";
	 * testdata(excelPath,"Sheet1"); }
	 */
	static String projectPath  = System.getProperty("user.dir");
	WebDriver driver = null;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void TestSetups(String browserName)  throws Exception {	
		
		System.out.println("Browser Name is  "+  browserName);
		System.out.println("Thread id is :"+Thread.currentThread().getId());
		System.out.println("Thread id is :"+Thread.currentThread().getName());
		
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
	
	
	
	
	
	
	@Test(dataProvider="test1data",priority=2)
	public void Test1(String username,String password) throws Exception {	
		//System.out.println(username+" | "+password);
		driver.get("https://google.com");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(username+Keys.RETURN);
		Thread.sleep(3000);		
	}
	
	@Test(priority=1)
	public void Test2() throws Exception {	
		driver.get("https:/google.com");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("Ragahav Pal"+Keys.RETURN);
		Thread.sleep(3000);
		Assert.assertTrue(false);
		
	}
	
	
	@Test(priority=3)
	public void Test3() throws Exception {	
		driver.get("https:/google.com");
		Thread.sleep(3000);
		throw new SkipException("Skip this test");	
	}
	
	@Test
	public void Test4() throws Exception {	
		driver.get("https:/google.com");
		Thread.sleep(3000);
		System.out.println("Test4 print statement: completed successfully");
		
	}
	
	@Test
	public void Test5() throws Exception {	
		driver.get("https:/google.com");
		Thread.sleep(3000);
		Assert.assertTrue(true);
	}
	
	
	
	
	
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
		System.out.println("this is after all tests completed");
		
	}
	
	
	@DataProvider(name="test1data")
	public static Object[][] getdata() {
		String excelPath  = projectPath+"/Excel/testdata1.xlsx";
		Object data[][] = testdata(excelPath,"Sheet1");
		return data;
		
	}
	
	@SuppressWarnings("static-access")
	public static Object[][] testdata(String excelPath,String Sheetname) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, Sheetname);
		int RowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		Object data[][] = new Object[RowCount-1][colCount] ;
		
		for(int i=1;i<RowCount;i++) {		
			for(int j=0;j<colCount;j++) {
				
				String CellData = excel.getCellDataString(i, j);
				//System.out.print(CellData+" | ");
				data[i-1][j] = CellData;		
				//System.out.print(data[i-1][j]+" | ");
			}
			System.out.println();
		}
		return data;
	}

}

