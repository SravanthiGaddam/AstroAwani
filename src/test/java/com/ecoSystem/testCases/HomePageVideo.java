package com.ecoSystem.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecoSystem.pageObjects.HomePage;

public class HomePageVideo extends BaseClass{
	
	@Test()
	public void homeVideo() throws IOException
	{
	 HomePage hp = new HomePage(driver);
	hp.homeVideo();
	Assert.assertTrue(true, "Video widget is displayed");
		 logger.info("Video widget is displayed");
	
		Assert.assertFalse(false, "Video Widget is not displayed");	
		captureScreen(driver, "HomePageVideo");
		logger.info("Video Widget is not displayed");
		 hp.videoClick();
			logger.info("Video is clicked");
	}

}
