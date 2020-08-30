package Dance;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Base;

public class ValidateTest extends Base{ //Using inheritance to get properties of Base class by using 'extends' keyword
	
	public WebDriver driver;
	LandingPage la;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void init2() throws IOException
	{
		driver = initializeDriver(); //Use initailizeDriver method declared in base class to get driver information
		log.info("Driver is Initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		la = new LandingPage(driver);
		Assert.assertEquals(la.getFeatured().getText(), "Featured Courses");
		log.info("Successfully validated 'Featured Courses' text");
		
		Assert.assertTrue(la.getMentor().isDisplayed());
		log.info("Successfully displaying Mentorship tab");
		
	}
	
	@Test
	public void HeaderValidate() throws IOException
	{
		la = new LandingPage(driver);
		Assert.assertEquals(la.getHeader().getText(), "An Academy to Learn Earn & Shine  in your QA Career");
	}
	
	@AfterTest
	public void outit2()
	{
		driver.close();
	}
		
	}

