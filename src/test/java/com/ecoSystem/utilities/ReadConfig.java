package com.ecoSystem.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
		public ReadConfig()
		{
		File src = new File("./Configuration\\config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
					prop = new Properties();
			prop.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is" + e.getMessage());
		}		
	}
		public String getApplicationURL()
		{
			String url = prop.getProperty("baseURL");
			return url;
			
		}
		public String getChromePath()
		{
			String chromepath = prop.getProperty("chromepath");
			return chromepath;
		}
		public String getFFPath()
		{
			String firefoxpath = prop.getProperty("firefoxpath");
			return firefoxpath;
		}
		
		public String getHomePageTitle()
		{
			String htitle = prop.getProperty("HTitle");
			return htitle;
		}
		
		public String getGalleryListingPageTitle()
		{
			String gltitle = prop.getProperty("GLTitle");
			return gltitle;
		}
}
