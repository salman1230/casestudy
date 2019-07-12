package com.casestudy.groupsix_casestudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageDef
{
	WebDriver driver;

	public PageDef(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.LINK_TEXT,using="SignIn")
	@CacheLookup
	WebElement btn1;

	@FindBy(name = "userName")
	@CacheLookup
	WebElement username;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement pass;

	@FindBy(name = "Login")
	@CacheLookup
	WebElement btn2;

	public void login_new(String uid, String pwd) {
		btn1.click();
		username.sendKeys(uid);
		pass.sendKeys(pwd);
		btn2.click();
	}

}
