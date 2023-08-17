package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferpage {
	@FindBy(xpath="//input[@name='customer_id']")
	private WebElement customerid;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(xpath="//input[@name='login-btn']")
	private WebElement login;
	public WebElement getCustomerid() {
		return customerid;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	public FundTransferpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
