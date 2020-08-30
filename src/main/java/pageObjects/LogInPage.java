package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	public WebDriver driver;
	
	private By email = By.id("user_email");
	private By password = By.id("user_password");
	private By LogIn = By.name("commit");
	private By Forgot = By.className("link-below-button");
	//Creating a constructor in order for the contents of this class to be made accessible to HomePage class
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement LogIn()
	{
		return driver.findElement(LogIn);
	}
	
	public ResetPage getForgotPassword()
	{
		driver.findElement(Forgot).click();
		ResetPage rp = new ResetPage(driver);
		return rp;
	}
}
