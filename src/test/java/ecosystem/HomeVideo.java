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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomeVideo {
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
		  public void video() throws Exception {
			  driver.findElement(By.xpath("//section[@class='widget bg-dark-grey overlay']"));
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 driver.findElement(By.xpath("//h2[contains(text(),'Video')]"));
				assertTrue(true, "Video widget is not found");
				      }
		  
	@Test (priority=3)
		  public void videoClick()  throws Exception{
WebElement podLink =  driver.findElement(By.xpath("//section[@class='widget bg-dark-grey overlay']//h3[@class='headlines regular']"));
	podLink.click();
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\podlink.jpg"));
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

