package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.ExcelUtility;

public class ApplyDebitCardHomePage {
	@FindBy(xpath="//input[@placeholder='Account Holder Name']")
	private WebElement accountholdername;
	@FindBy(xpath="//input[@placeholder='Date of Birth']")
	private WebElement dob;
	@FindBy(xpath="//input[@placeholder='PAN']")
	private WebElement pan;
	@FindBy(xpath="//input[@placeholder='Registered Mobile (10 Digit)']")
	private WebElement mobile;
	@FindBy(xpath="//input[@placeholder='Account No']")
	private WebElement accountno;
	@FindBy(xpath="//input[@name='dbt_crd_submit']")
	private WebElement submit;
	@FindBy(xpath="//a[.='Home']")
	private WebElement homebtn;
	public WebElement getAccountholdername() {
		return accountholdername;
	}
	public WebElement getDob() {
		return dob;
	}
	public WebElement getPan() {
		return pan;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getAccountno() {
		return accountno;
	}
	public WebElement getDebitcard() {
		return submit;
	}
	public WebElement gethomebtn()
	{
		return homebtn;
	}
	public ApplyDebitCardHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	ExcelUtility exutil=new ExcelUtility();
	public void applydebitcard(String name,String accountn) throws Throwable
	{
		accountholdername.sendKeys(name);
		dob.click();
		dob.sendKeys(exutil.readDataFromExcel("accountdetails", 5, 1));
		pan.sendKeys(exutil.readDataFromExcel("accountdetails", 6, 1));
		mobile.sendKeys(exutil.readDataFromExcel("accountdetails", 2, 1));
		accountno.sendKeys(accountn);
		submit.click();
	}
	public void clickOnHome()
	{
		homebtn.click();
	}

}
