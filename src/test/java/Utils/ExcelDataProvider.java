package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.PropertiesFile;


// -- @Listeners(listeners.TestNGListeners.class)
public class ExcelDataProvider {
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * String excelPath = System.getProperty("user.dir")+"/Excel/testdata1.xlsx";
	 * testdata(excelPath,"Sheet1"); }
	 */
	static String projectPath  = System.getProperty("user.dir");
	WebDriver driver = null;
	
	
	@BeforeTest
	public void TestSetups() {	
		PropertiesFile.getProperties();
		
			//chrome driver
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");			
			driver =    new ChromeDriver();				
			driver.manage().window().maximize();
			
	}
	
	
	@Test(dataProvider="test1data")
	
	public void Test1(String username,String password) throws InterruptedException {
		
		//System.out.println(username+" | "+password);
		driver.get("https:/google.com");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(username+Keys.RETURN);
		Thread.sleep(3000);
		
	}
	
	@Test(dataProvider="test1data")
	
	public void Test2(String username,String password) throws InterruptedException {
		
		//System.out.println(username+" | "+password);
		driver.get("https:/google.com");
		Thread.sleep(3000);
		driver.findElement(By.name("q22")).sendKeys(username+Keys.RETURN);
		Thread.sleep(3000);
		
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
