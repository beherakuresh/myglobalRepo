package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingLoginPage {
@FindBy(xpath="//input[@name='customer_id']")
private WebElement customerid;
@FindBy(xpath="//input[@name='password']")
private WebElement password;
@FindBy(xpath="//input[@name='login-btn']")
private WebElement loginbutton;
public WebElement getCustomerid() {
	return customerid;
}
public WebElement getPassword() {
	return password;
}
public WebElement getLoginbutton() {
	return loginbutton;
}
public InternetBankingLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
