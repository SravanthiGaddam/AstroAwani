package com.ecoSystem.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GalleryPage {
	
	WebDriver ldriver;
	public GalleryPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Foto')]")
	WebElement Foto;
	
	@FindBy(xpath="//h1[@class='img-title']")
	WebElement FotoTitle;
	
	@FindBy(xpath="//div[@id='p_lt_ctl00_pageplaceholder_p_lt_ctl01_DEImageGalleryFeaturedAlbum_dvFeaturedAlbum']//div[@class='display-flex date-subtitle']")
	WebElement PublishDate;
	
	public void fotoClick()
	{
		Foto.click();
	}
	
	public void fotoTitle()
	{
		FotoTitle.isDisplayed();
	}
	
	public void fotoPublishDate()
	{
	PublishDate.isDisplayed();
	}
}
