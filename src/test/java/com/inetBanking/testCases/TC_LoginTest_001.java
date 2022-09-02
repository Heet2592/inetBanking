package com.inetBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(USERNAME);
		logger.info("UserName is Entered");
		lp.setPassword(PASSWORD);
		logger.info("Password is entered");
		lp.clickSubmit();
		logger.info("Button clicked");
		
		//Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			System.out.println("Test Passed");
		}else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			System.out.println("Test failed");
		}
	
	}

}
