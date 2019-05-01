package ecosystem;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

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

public class PodCastTest {
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
		  public void podCast() throws Exception {
			  driver.findElement(By.xpath("//div[@class='widget divider podcast row hidden-xs hidden-sm']"));
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  String ptitle = "Podcast";
				WebElement pod = driver.findElement(By.xpath("//div[@class='widget divider podcast row hidden-xs hidden-sm']//h2[@class='title mt-0 mb-0 f-grow']"));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				String Title = pod.getText();
					Assert.assertEquals(Title,ptitle, "Podcast widget is not found"); 
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				    FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\pod.jpg"));
				    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				      }
		  
	@Test (priority=3)
		  public void podCastClick()  throws Exception{
WebElement podLink =  driver.findElement(By.xpath("//div[@class='widget divider podcast row hidden-xs hidden-sm']//h3[@class='media-headlines small']"));
	podLink.click();
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\podlink.jpg"));
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
/*for (int i=0; i<=podLink.size(); i++) {
		//	podLink =  driver.findElements(By.xpath("//body[@class='LTR Chrome MSMY ContentBody']/form[@method='post']/section[@class='features']/div[@class='container']/div[@class='row']/div[@class='col-md-4']/div[@class='widget divider podcast row hidden-xs hidden-sm']/div[@class='col-md-12']/div[@class='full-width']/ul[@class='scroll-x pl-0']/li[1]/div[1]/div[2]"));
		  wait.until(ExpectedConditions.visibilityOf(podLink.get(i)));
		  podLink.get(i).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    System.out.print(i + " element clicked\t--");
	    System.out.println("pass");
	    driver.navigate().back();
	try {
		driver.navigate().refresh();
	 for (WebElement pods:podLink)
				  pods.click();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.navigate().back(); 
			  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Images\\podlink.jpg"));
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	catch(org.openqa.selenium.StaleElementReferenceException ex)
	{
		 for (WebElement pods:podLink)
			  pods.click();
	}
	*/
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
