package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
	LoginPage login = new LoginPage(driver);	
	login.setUserName(USERNAME);
	login.setPassword(PASSWORD);
	login.clickSubmit();
	
	Thread.sleep(3000);
	AddCustomerPage addcustomer = new AddCustomerPage(driver);
	
	addcustomer.clickAddCustLink();
	Thread.sleep(3000);
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='3rd party ad content']")));
	addcustomer.closePopUp();
	driver.switchTo().defaultContent();
	addcustomer.custname("Abc");
	addcustomer.custgender("Male");
	addcustomer.custdbo("1885", "15", "08");
	Thread.sleep(3000);
	addcustomer.custaddress("ABC Drive");
	addcustomer.custcity("DEF");
	addcustomer.custstate("Guj");
	addcustomer.custpine("123465");
	addcustomer.custtelephoneno("1234567894");
	String email = randomString()+"@gmail.com";
	addcustomer.custemail(email);
	addcustomer.custpassword("465asd");
	addcustomer.submitBtn();
//
//	boolean res = driver.getPageSource().contains("");
//	
//	if(res==true) {
//		Assert.assertTrue(true);
//	}
//	else {
//		captureScreen(driver,"AddCustomer");
//		Assert.assertTrue(false);
//	}
	
	
	
	}
	
	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

}
