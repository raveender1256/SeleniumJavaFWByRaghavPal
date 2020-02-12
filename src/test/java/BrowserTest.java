import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		String Projectpath = System.getProperty("user.dir");		
		System.out.println("Projectpath: "+ Projectpath);
		
		// geckodriver
		//System.setProperty("webdriver.gecko.driver", Projectpath+"\\Drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//chrome driver
		System.setProperty("webdriver.chrome.driver", Projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selenium.dev/");
		
	}

}
