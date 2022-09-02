package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	
	public String BASE_URL = readconfig.getBaseURL();
	public String USERNAME = readconfig.getUserName();
	public String PASSWORD = readconfig.getPassword();
	public static WebDriver driver;

	public Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome")String br) {
		
		logger = Logger.getLogger("e-Banking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath()); 
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath()); 
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			//System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath()); 
			//driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screen Shot Taken");
	}
}
