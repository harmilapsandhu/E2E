package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	//declare variables first
	//By signin = By.cssSelector("div[class='login-btn'] a");    //parent-child traverse (wrong in this case)
	 private By signin = By.cssSelector("a.theme-btn.register-btn");  //tagname.classname (replacing space in classname with .)
	 private By display = By.xpath("//h2[text()='Featured Courses']"); //for some reason, Xpath didn't work
	 private By mentor = By.xpath("//a[text()='Mentorship']");
	 private By header = By.xpath("//span[text()='An Academy to ']");
	//Creating a constructor in order for the contents of this class to be made accessible to HomePage class
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//declare methods second (Accessor Methods)
	public LogInPage getLogIn()
	{
		driver.findElement(signin).click();  //Clicking login takes you to another page hence we made an object of
		LogInPage lo = new LogInPage(driver);//of that page in this step and return it
		return lo;
	}
	
	
	public WebElement getFeatured()
	{
		return driver.findElement(display);
	}
	
	public WebElement getMentor()
	{
		return driver.findElement(mentor);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
	
}
