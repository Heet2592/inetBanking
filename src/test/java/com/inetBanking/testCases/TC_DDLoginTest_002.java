package com.inetBanking.testCases;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_DDLoginTest_002 extends BaseClass{
	
	String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
	XLUtils xlutils = new XLUtils(path);
	
	@Test(dataProvider ="LoginTest")
	public void getLogin(String user,String password) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("UserName is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		logger.info("Submit is clicked");
		
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Test Failed");
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test Passed");
		}
		
	}
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			
			return false;	
		}
		
		
	}
	
	@DataProvider(name="LoginTest")
	String[][] getData(){
		
		
		int rowCount = xlutils.getRowCount("Sheet1");
		int colCount = xlutils.getColumnCount("Sheet1");
		
		System.out.println(rowCount + " " + colCount);
		
		String loginData[][] = new String[rowCount-1][colCount];

		for(int i=2;i<=rowCount;i++) { //2 3 4 5
			
			for(int j=0;j<colCount;j++) {
				
				loginData[i-2][j] = xlutils.getCellData("Sheet1", j, i);
			}
			
		}
		return loginData;
		
	}

}
