package ecosystem;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Popup {

		WebDriver driver;
			  
			  @Test ()
			  public void pageLoad()  throws Exception{
				  driver.get("http://staging-de.pink.cat/");
				  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.manage().window().maximize();
		WebElement popup =	driver.findElement(By.id("STO-Pop"));      
		    ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", popup);  
		    String ptitle = "Astro Awani, Berita Tajuk Utama Hari Ini, Berita Semasa, Berita Terkini Malaysia, Dunia, Sukan, Hiburan, Teknologi, Gaya Hidup, Automotif, Politik, Foto, Video, dan Siaran Langsung TV | Astro Awani";
			String Title = driver.getTitle();
				Assert.assertEquals(Title,ptitle, "Home Page not found"); 
			  }
			  
			  @Test (priority=2)
			  public void video() throws Exception {
				  driver.findElement(By.xpath("//a[contains(text(),'Foto')]")).click();;
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Video Page");
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

