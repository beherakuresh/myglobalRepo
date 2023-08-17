package com.banking.onlinebanking.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void validation()
	{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	String actualtitle=driver.getTitle();
	String exp="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	Assert.assertEquals(actualtitle, exp);
	System.out.println("title is  matching for amazon");
	
	
	}
	@Test
	public void myvalidation()
	{
		WebDriver driver=new EdgeDriver();
		driver.get("https://demo.actitime.com/login.do");
		String title=driver.getTitle();
		String exp="amazon";
		Assert.assertEquals(title, exp);
		System.out.println("this is actitime login page");
	}
	
	
	

}
