package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage{
	
	WebDriver lDriver;
	
	public AddCustomerPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);;
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement addCustLink;
	
	@FindBy(xpath = "//div[@id='dismiss-button']")
	@CacheLookup
	WebElement closePopUp;
	
	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement name;
	
	@FindBy(xpath="//input[@name='rad1'][1]")
	@CacheLookup
	WebElement maleRadioBtn;
	
	@FindBy(xpath="//input[@name='rad1'][2]")
	@CacheLookup
	WebElement femaleRadioBtn;
	
	@FindBy(xpath="//input[@name='dob']")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement city;
	
	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	WebElement address;
	
	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	WebElement pinno;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH, using ="//input[@name='sub']")
	@CacheLookup
	WebElement sub;
	
	@FindBy(xpath="//*[@id='ad_iframe']")
	@CacheLookup
	public WebElement frame;
	
	public void clickAddCustLink() {
		addCustLink.click();
	}
	
	public void custname(String cname) {
		name.sendKeys(cname);
	}

	public void custgender(String cgender) {
		maleRadioBtn.click();
	}

	public void custdbo(String yy,String dd,String mm) {
		DOB.sendKeys(yy);
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		
	}

	public void custcity(String ccity) {
		city.sendKeys(ccity);
	}

	public void custaddress(String caddress) {
		address.sendKeys(caddress);
	}

	public void custstate(String cstate) {
		state.sendKeys(cstate);
	}

	public void custpine(String cpin) {
		pinno.sendKeys(String.valueOf(cpin));
	}
	

	public void custtelephoneno(String ctelephoneno) {
		phoneNumber.sendKeys(ctelephoneno);
	}

	public void custemail(String cemail) {
		email.sendKeys(cemail);
	}
	public void custpassword(String cpassword) {
		password.sendKeys(cpassword);
	}
	
	public void closePopUp() {
		
		closePopUp.click();
	}
	
	public void submitBtn() {
		sub.click();
	}
	
	
	

}
