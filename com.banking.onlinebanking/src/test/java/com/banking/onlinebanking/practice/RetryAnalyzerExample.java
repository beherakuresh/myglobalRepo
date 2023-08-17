package com.banking.onlinebanking.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerExample 
{
	@Test(retryAnalyzer=com.banking.GenericUtility.RetryImplementationClass.class)
	public void validation()
	{
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	String actualtitle=driver.getTitle();
	String exp="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	Assert.fail();
	System.out.println("title is  matching for amazon");
	
	
	
	}
	@Test
	public void myvalidation()
	{
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demo.actitime.com/login.do");
		String title=driver.getTitle();
		//String exp="actitime";
		//sa.assertEquals(title, exp);
		Assert.fail();
		System.out.println("this is actitime login page");
		
	}

	

}
