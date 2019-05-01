package com.ecoSystem.testCases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecoSystem.pageObjects.GalleryPage;

public class TC_GLTitle_C11907 extends BaseClass

{
  @Test()
	public void galleryTitle() throws IOException
	{
	 GalleryPage gl = new GalleryPage(driver);
		 gl.fotoClick();
		 logger.info("Gallery link clicked");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.getTitle().equals(GLTitle))
		{
		Assert.assertTrue(true);	
		logger.info("Gallery Listings page is opened");
		}
		else
		{
		captureScreen(driver, "galleryTitle");
		Assert.assertTrue(false);
		logger.info("Gallery Listings Page is not displayed");
		}
		  gl.fotoTitle();
			logger.info("Gallery Title is displayed");
	}
 
}
