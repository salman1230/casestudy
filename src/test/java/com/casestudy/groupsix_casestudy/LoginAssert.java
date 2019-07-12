package com.casestudy.groupsix_casestudy;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginAssert
{
	int i;
	WebDriver driver;
	@Given("^user is on the home page$")
	public void user_is_on_the_home_page() throws Throwable {
		driver = Utility.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		Assert.assertEquals(driver.getTitle(), "Home");
	}
	@Given("^Login using <Username1> and <Password1>$")
	public void login_using_Username_and_Password(DataTable dt) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String,String>> list=dt.asMaps(String.class, String.class);
		 for(i=0;i<list.size();i++) {
			 
			 PageDef login = PageFactory.initElements(driver, PageDef.class);
				login.login_new(list.get(i).get("Username1"), 
					 (list.get(i).get("Password1")));
				
	}
			 
		
	}
	
	 @Then("^User landed in homepage$")
	 public void user_landed_in_homepage() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(driver.getTitle(),"Home");
	     
	     
	 }
	
}