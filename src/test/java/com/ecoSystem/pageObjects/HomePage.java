package com.ecoSystem.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//h2[contains(text(),'Video')]")
	WebElement HomeVideo;
	
	@FindBy(xpath="//section[@class='widget bg-dark-grey overlay']//h3[@class='headlines regular']")
	WebElement HomeVideoclick;
	
	public void homeVideo()
	{
	HomeVideo.isDisplayed();
		}
	
	public void videoClick()
	{
		HomeVideoclick.click();
	}

}
