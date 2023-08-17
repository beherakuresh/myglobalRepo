package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {
	@FindBy(xpath="//input[@name='viewdet']")
	private WebElement viewActiveCustomer;
	@FindBy(xpath="//input[@name='view_cust_by_ac']")
	private WebElement viewCustomerByAc;
	@FindBy(xpath="//input[@name='apprvac']")
	private WebElement approvePendingAc;
	@FindBy(xpath="//input[@name='del_cust']")
	private WebElement deleteCustomerAc;
	@FindBy(xpath="//input[@name='credit_cust_ac']")
	private WebElement creditCustomer;
	@FindBy(xpath="//input[@name='logout_btn']")
	private WebElement logoutbtn;
	public WebElement getviewActiveCustomer()
	{
		return viewActiveCustomer;
	}
	public WebElement getViewCustomerByAc() {
		return viewCustomerByAc;
	}
	public WebElement getApprovePendingAc() {
		return approvePendingAc;
	}
	public WebElement getDeleteCustomerAc() {
		return deleteCustomerAc;
	}
	public WebElement getCreditCustomer() {
		return creditCustomer;
	}
	public WebElement getlogoutbtn()
	{
		return logoutbtn;
	}
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void aprovePendingAccount()
	{
		approvePendingAc.click();
	}
	public void clickOnLogoutbtn()
	{
		logoutbtn.click();
	}
	

}
