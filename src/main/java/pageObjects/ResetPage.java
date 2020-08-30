package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPage {
	
	public WebDriver driver;
	
	private By EnterEmail = By.xpath("//div[@class='control-input']/div/input");
	private By Send = By.cssSelector("input.btn.btn-primary.btn-md");
	
	public ResetPage(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	public WebElement getEnterEmail()
	{
		return driver.findElement(EnterEmail);
	}
	
	public WebElement getSendInstructions()
	{
		return driver.findElement(Send);
	}
}
