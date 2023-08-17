package com.banking.pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.WebDriverUtility;

public class Homepage {
	@FindBy(xpath="//a[.='Staff Login']")
	private WebElement stafflogin;
	@FindBy(xpath="//li[.='Open Account']")
	private WebElement openaccount;
	@FindBy(xpath="//li[.='Apply Debit Card']")
	private WebElement applydebitcard;
	@FindBy(xpath="//a[contains(text(),'Internet Banking')]")
	private WebElement internetbanking;
	@FindBy(xpath="//li[.='Fund Transfer']")
	private WebElement fundtransfer;
	@FindBy(xpath="//li[.='Login ']")
	private WebElement login;
	@FindBy(xpath="//li[.='Register']")
	private WebElement register;
	public WebElement getStafflogin() {
		return stafflogin;
	}
	public WebElement getOpenaccount() {
		return openaccount;
	}
	public WebElement getApplydebitcard() {
		return applydebitcard;
	}
	public WebElement getInternetbanking() {
		return internetbanking;
	}
	public WebElement getFundtransfer() {
		return fundtransfer;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getRegister() {
		return register;
	}
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickonStaffLogin()
	{
		stafflogin.click();
	}
	public void clickonOpenAccount()
	{
		openaccount.click();
	}
	public void clickonApplydebitcard()
	{
		applydebitcard.click();
	}
	
	WebDriverUtility wutil=new WebDriverUtility();
//	public void mouseHoverOnInternetBanking(WebDriver driver)
//	{
//		wutil.mouseHovering(driver, internetbanking);
//	}
	public void clickoninternetbankingLogin() {
		login.click();
	}
	public void clickOninternetBankingRegister(WebDriver driver) throws Throwable
	{	wutil.pageScrolling();
		Thread.sleep(8000);
		wutil.mouseHovering(driver, internetbanking);
		Thread.sleep(2000);
		wutil.pageScrolling();
		register.click();
	}
	public void clickOnFundTransfer()
	{
		fundtransfer.click();
	}

}
