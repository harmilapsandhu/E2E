package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver; //Declared WebDriver driver here to extend the scope of WebDriver to entire class
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		//This links this Base class to data.properties file with browser information
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");  //Avoided hard-coding by using user.dir
		prop.load(fis); //This automatically loads all the properties listed in .properties file
		
		//To give browser information in mvn instead of .properties file, we use below syntax (mvn test -Dbrowser=chrome)
		//String browserName = System.getProperty("browser");  //for use with maven or Jenkins parameterization
		String browserName = prop.getProperty("browser");  //get browser info from properties file
		
		if(browserName.equals("chrome")) //we use '.equals' rather than '==' as our object ie chrome is in a different memory location
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();  //Created object options for ChromeOptions class
			//options.addArguments("headless"); //Execute tests without opening of chrome browser
			driver=new ChromeDriver(options);
		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harmilap\\Documents\\Work\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Harmilap\\Documents\\Work\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
}
