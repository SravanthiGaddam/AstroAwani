package com.ecoSystem.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecoSystem.pageObjects.GalleryPage;

public class GalleryPagePublishDate extends BaseClass{
	
	  @Test()
		public void galleyPublishDate() throws Exception
		{
		 GalleryPage gl = new GalleryPage(driver);
			 gl.fotoClick();
			 logger.info("Gallery link clicked");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver.getTitle().equals(GLTitle))
				{
				Assert.assertTrue(true, "Gallery Listings page is opened");
				logger.info("Gallery Listings page is opened");
				}
				else
				{
				captureScreen(driver, "galleyPublishDate");
				Assert.assertTrue(false, "Gallery Listings page is not opened");
				logger.info("Gallery Listings Page is not displayed");
				}
			  gl.fotoPublishDate();
				logger.info("Publish Date is displayed");
			
		}

}
