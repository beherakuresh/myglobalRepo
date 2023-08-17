package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterApplicationNumHomePage {
	@FindBy(xpath="//input[@placeholder='Application number']")
	private WebElement applicationNumTextbox;
	@FindBy(xpath="//input[@name='search_application']")
	private WebElement searchbox;
	@FindBy(xpath="//input[@name='approve_cust']")
	private WebElement approvebtn;
	@FindBy(xpath="//a[.='Home']")
	private WebElement homebtn;
	
	public WebElement getApplicationNumTextbox() {
		return applicationNumTextbox;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getApprovebtn() {
		return approvebtn;
	}
	public WebElement gethomebtn()
	{
		return homebtn;
	}

	public EnterApplicationNumHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void approve(String applicationnum) throws Throwable
	{
		applicationNumTextbox.sendKeys(applicationnum);
		Thread.sleep(8000);
		searchbox.click();
		Thread.sleep(8000);
		approvebtn.click();
		Thread.sleep(8000);
	}
	public void clickOnHome() 
	{
		homebtn.click();
	}
	
			

}
