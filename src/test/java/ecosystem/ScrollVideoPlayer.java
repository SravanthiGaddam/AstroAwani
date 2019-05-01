package ecosystem;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollVideoPlayer {
	WebDriver driver;
		  
		  @Test (priority=1)
		  public void pageLoad()  throws Exception{
			  driver.get("http://staging-de.pink.cat/");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			  String ptitle = "Astro Awani, Berita Tajuk Utama Hari Ini, Berita Semasa, Berita Terkini Malaysia, Dunia, Sukan, Hiburan, Teknologi, Gaya Hidup, Automotif, Politik, Foto, Video, dan Siaran Langsung TV | Astro Awani";
				String Title = driver.getTitle();
					Assert.assertEquals(Title,ptitle, "Home Page not found"); 
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				    FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\HomePage.jpg"));
				    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
		  @Test (priority=2)
		  public void videoPage() throws Exception {
			  driver.findElement(By.xpath("//a[@data-content-title='Video']")).click();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  String URL = "http://staging-de.pink.cat/video-listing";
				String PURL = driver.getCurrentUrl();
				Assert.assertEquals(URL,PURL, "Video Page not found"); 
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\VideoPage.jpg"));
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				      }
		  
	@Test (priority=3)
		  public void playButton()  throws Exception{
 driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-display jw-button-color jw-reset']")).click();
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\videolink.jpg"));
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test (priority=4)
	  public void scrollVideo()  throws Exception{
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollTo(0, document.body.scrollHeight)");
driver.findElement(By.xpath("//video[@class='jw-video jw-reset']")).isDisplayed();
assertTrue(true, "Video is not displayed");
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\videolink.jpg"));
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
		  
	@BeforeTest
	  public void beforeTest() {
		   System.setProperty("webdriver.chrome.driver", "D:/Selenium/Chrome Driver/chromedriver.exe");
		  driver= new ChromeDriver();
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}


