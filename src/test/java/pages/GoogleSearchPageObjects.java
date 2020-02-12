package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By textBox_search = By.name("q");
	By Search_button = By.name("btnK");
	
	public void SetTextIntoSearchBox(String Searchtext)
	{
		driver.findElement(textBox_search).sendKeys(Searchtext + Keys.ENTER);
	}
	
	public void ClickSearch()
	{
		driver.findElement(textBox_search).click();
	}

}
