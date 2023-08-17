package com.banking.onlinebanking.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	@Test()
	public void validation()
	{
	SoftAssert sa=new SoftAssert();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	String actualtitle=driver.getTitle();
	String exp="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	sa.assertEquals(actualtitle, exp);
	System.out.println("title is  matching for amazon");
	sa.assertAll();    //compolsory method
	
	
	}
	@Test
	public void myvalidation()
	{
		SoftAssert sa=new SoftAssert();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demo.actitime.com/login.do");
		String title=driver.getTitle();
		//String exp="actitime";
		//sa.assertEquals(title, exp);
		sa.assertTrue(title.contains("acti"));
		System.out.println("this is actitime login page");
		sa.assertAll();  //compolsory method
	}

}



