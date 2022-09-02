package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;

	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream ip = new FileInputStream(src);
			prop = new Properties();
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is :" + e.getMessage());
		}
		
		
		
	}
	
	public String getBaseURL() {
		String url= prop.getProperty("BASE_URL");
		return url;
	}
	public String getUserName() {
		String userName = prop.getProperty("USERNAME");
		return userName;
	}
	public String getPassword() {
		String password = prop.getProperty("PASSWORD");
		return password;
	}
	public String getFireFoxPath() {
		String fireFoxPath = prop.getProperty("firefoxpath");
		return fireFoxPath;
	}
	public String getChromepath() {
		String chromePath = prop.getProperty("chropath");
		return chromePath;
	}
}

