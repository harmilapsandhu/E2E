package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHome {
	
	public WebDriver driver;
	
	By SearchBox = By.id("search-courses");
	
	public PortalHome(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement getSeach()
	{
		return driver.findElement(SearchBox);
	}
}
