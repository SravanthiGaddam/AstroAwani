package com.ecoSystem.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.ecoSystem.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
    public String HTitle = readconfig.getHomePageTitle();
	public String GLTitle = readconfig.getGalleryListingPageTitle();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
		public void setup(String br)
		{
		
		  logger = Logger.getLogger("BaseClass");
			DOMConfigurator.configure("log4j.xml");
			
			if (br.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+readconfig.getChromePath());
		driver = new ChromeDriver();
			}
			else if (br.equals("firefox"))
			{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+readconfig.getFFPath());
		driver = new FirefoxDriver();
			}
		logger.info("Driver Initialzed");
         driver.get(baseURL);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement popup =	driver.findElement(By.id("STO-Pop"));   
		 if(popup.isDisplayed())
		 {
		    ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", popup); 
		 }
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Assert.assertEquals(driver.getTitle(), HTitle, "Home Page is not displayed");
		 logger.info("Site Opened");
}

	
   @AfterClass
   public void quit()
   {
	   driver.quit();
   }
   public void captureScreen(WebDriver driver, String screenshotName) throws java.io.IOException{
		 TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/Screenshots/"+ screenshotName +".png");
		FileUtils.copyFile(src, dest);
		logger.info("Screenshot taken");
   }
}
