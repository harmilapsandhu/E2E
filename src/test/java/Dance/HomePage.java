package Dance;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogInPage;
import pageObjects.ResetPage;
import resources.Base;

public class HomePage extends Base{ //Using inheritance to get properties of Base class by using 'extends' keyword
	
	public WebDriver driver;
	LandingPage la;
	//LogInPage lo;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	/*@BeforeTest
	public void browserInvoke() throws IOException
	{
		driver = initializeDriver(); //Use initailizeDriver method declared in base class to get driver information
	}*/
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException
	{
		driver = initializeDriver(); //Use initailizeDriver method declared in base class to get driver information
		driver.get(prop.getProperty("url"));
		
		//There are 2 ways of getting properties of another class:
		// 1. Inheritance as defined above using extends keyword
		// 2. Defined below - Creating object of that class and invoke methods of it
		
		la = new LandingPage(driver);
		//la.getLogIn();  //We skipped this step with the below step
		LogInPage lo = la.getLogIn();
		
		//LogInPage lo = new LogInPage(driver); //We have optimized this step and removed one new object by integrating it in LandingPage(Lec. 215)
		lo.email().sendKeys(username);
		lo.password().sendKeys(password);
		log.info(text);
		lo.LogIn().click();
		
	}
	
		//Now to avoid hardcoding the data, we will use @DataProvider Annotation to drive data
		
		@DataProvider
		public Object[][] getData()
		{
			Object[][] data = new Object[2][3];  //For 2 rows and 3 columns
			data[0][0] = "non-restrictedUser@qa.com";
			data[0][1] = "MyPassword";
			data[0][2] = "Value 1";
			
			data[1][0] = "restricetedUser@qa.com";
			data[1][1] = "YourPassword";
			data[1][2] = "Value 2";
			return data;
			
			//The browser will be invoked twice, each time with different data values. Watch video 202 & 203 for parameterization
					
		} 
		
		@Test
		public void Forgot() throws IOException
		{			
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
			
			la = new LandingPage(driver);
			LogInPage lo = la.getLogIn();
			ResetPage rp = lo.getForgotPassword();
			rp.getEnterEmail().sendKeys("iforrgot@qac.com");
			rp.getSendInstructions().click();
		
		}
		
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		} 
	}

