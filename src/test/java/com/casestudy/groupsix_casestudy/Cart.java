package com.casestudy.groupsix_casestudy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Cart 
{
	WebDriver driver;
	int cart,cart1;
	@Given("^Alex has registered in to TestMeApp$")
	public void alex_has_registered_in_to_TestMeApp() throws Throwable {
		driver = Utility.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		Assert.assertEquals(driver.getTitle(), "Home");
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys("Group6");
		driver.findElement(By.name("password")).sendKeys("group6");
		driver.findElement(By.xpath("//input[@type='submit' and @name='Login']")).click();
		Assert.assertEquals(driver.getTitle(), "Home");
		
	}

	@When("^Alex search a particular product like Headphone$")
	public void alex_search_a_particular_product_like_Headphone() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@type='text' and @name='products']")).sendKeys("Headphone");
		driver.findElement(By.xpath("//input[@type='submit' and @name='val']")).click();
	}

	@When("^Try to proceed to payment without adding any item in it$")
	public void try_to_proceed_to_payment_without_adding_any_item_in_it() throws Throwable
	{
		cart=driver.findElements(By.partialLinkText("Cart")).size();
		System.out.println("Cart has " + cart +" no of Items");
	}

	@Then("^TestMe doesn't display the cart icon$")
	public void testme_doesn_t_display_the_cart_icon() throws Throwable 
	{
		if(cart==0)
		{	
			System.out.println("TestMe doesn't display the cart icon");
			driver.findElement(By.linkText("Add to cart")).click();
			Assert.assertEquals(driver.getTitle(),"Search");
			cart1=driver.findElements(By.partialLinkText("Cart")).size();
			System.out.println("Cart has " + cart1 +" no of Items");
			if (cart1>0)
			{
				driver.findElement(By.xpath("//a [@href='displayCart.htm']")).click();
				Assert.assertEquals(driver.getTitle(),"View Cart");
				System.out.println("Item is now Added to Cart");
			}	
			else
			{ 
				System.out.print("Cart is empty");
			}
		}
		else
		{
			driver.findElement(By.xpath("//a [@href='displayCart.htm']")).click();
			Assert.assertEquals(driver.getTitle(),"View Cart");
			System.out.println("Item Added to Cart");
		}
		driver.findElement(By.linkText("Checkout")).click();
		Assert.assertEquals(driver.getTitle(), "Cart Checkout");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Proceed to Pay']")).click();
		WebDriverWait wait= new WebDriverWait(driver, 1000); 									
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("payment-info"))); 				
	
		Assert.assertEquals(driver.getTitle(),"Payment Gateway" );
		System.out.println("Landed in Payment Gateway");
		driver.close();
	}	
	
}
