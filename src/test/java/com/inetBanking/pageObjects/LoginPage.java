package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver){
		
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement btnLogOut;
	
	public void setUserName(String uname) {
		
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		
		txtPassword.sendKeys(pwd);
		
	}public void clickSubmit() {
		
		btnLogin.click();
	}
	public void clickLogOut() {
		btnLogOut.click();
	}
}
