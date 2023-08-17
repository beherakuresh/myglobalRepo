package com.banking.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.ExcelUtility;

public class InternetBankingRegistrationPage {
	@FindBy(xpath="//input[@name='holder_name']")
	private WebElement Holder_name;
     @FindBy(xpath = "//input[@name='accnum']")
     private WebElement Account_no ;
     @FindBy(xpath = "//input[@name='dbtcard']")
     private WebElement Debit_card;
     @FindBy(xpath="//input[@name='dbtpin']")
 	 private WebElement Debit_pin;
     @FindBy(xpath = "//input[@name='mobile']")
     private WebElement Mobile_no ;
     @FindBy(xpath = "//input[@placeholder='PAN Number']")
     private WebElement PAN_Number;
     @FindBy(xpath = "//input[@placeholder='Date of Birth']")
     private WebElement DOB;
     @FindBy(xpath = "//input[@placeholder='Last Transaction ($)']")
     private WebElement Last_Transcation;
     @FindBy(xpath = "//input[@placeholder='Password']")
     private WebElement Password;
     @FindBy(xpath = "//input[@placeholder='Confirm Password']")
     private WebElement Con_Password;
     @FindBy(xpath = "//input[@type='submit']")
     private WebElement Submit;
     ExcelUtility xutil=new ExcelUtility();
     public InternetBankingRegistrationPage(WebDriver driver)
      {
    	  PageFactory.initElements(driver, this);
      }
	public WebElement getHolder_name() {
		return Holder_name;
	}
	public WebElement getAccount_no() {
		return Account_no;
	}
	public WebElement getDebit_card() {
		return Debit_card;
	}
	public WebElement getDebit_pin() {
		return Debit_pin;
	}
	public WebElement getMobile_no() {
		return Mobile_no;
	}
	public WebElement getPAN_Number() {
		return PAN_Number;
	}
	public WebElement getDOB() {
		return DOB;
	}
	public WebElement getLast_Transcation() {
		return Last_Transcation;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getCon_Password() {
		return Con_Password;
	}
	public WebElement getSubmit() 
	{
		return Submit;
	}

	public void InternetBankingRegister(String name,String acc_no,String debit_card,String debit_pin,String mobileno,String pan,String pass) throws AWTException, InterruptedException
	{	Thread.sleep(2000);
		//Holder_name.click();
		Holder_name.sendKeys(name);
//		Account_no.sendKeys(acc_no);
//		Debit_card.sendKeys(debit_card);
//		Debit_pin.sendKeys(debit_pin);
//		Mobile_no.sendKeys(mobileno);
//		PAN_Number.sendKeys(pan);
//		DOB.click();
//		 
//	    Last_Transcation.sendKeys("0");
//	    Password.sendKeys(pass);
//	    Con_Password.sendKeys(pass);
//	    Submit.click();
	}
}
