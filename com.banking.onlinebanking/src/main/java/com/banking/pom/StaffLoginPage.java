package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	@FindBy(xpath="//input[@class=\"customer_id\"]")
	private WebElement staffid;
	@FindBy(xpath="//input[@class=\"password\"]")
	private WebElement password;
	@FindBy(xpath="//input[@class='login-btn']")
	private WebElement login;
	public WebElement getstaffid()
	{
		return staffid;
	}
	public WebElement getpassword()
	{
		return password;
	}
	public WebElement getlogin()
	{
		return login;
	}
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public void staffLogin(String id,String pwd)
	{
	staffid.sendKeys(id);
	password.sendKeys(pwd);
	login.click();
	}
	

}
