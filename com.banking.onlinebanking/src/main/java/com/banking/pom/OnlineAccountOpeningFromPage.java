package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.ExcelUtility;
import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.WebDriverUtility;

public class OnlineAccountOpeningFromPage  {
@FindBy(xpath="//input[@name=\"name\"]")
private WebElement name;
@FindBy(xpath="//select[@name='gender']")
private WebElement gender;
@FindBy(xpath="//input[@placeholder='Mobile no']")
private WebElement mobileno;
@FindBy(xpath="//input[@placeholder='Email id']")
private WebElement emailid;
@FindBy(xpath="//input[@placeholder='Landline no']")
private WebElement landline;
@FindBy(xpath="//input[@placeholder='Date of Birth']")
private WebElement dob;
@FindBy(xpath="//input[@placeholder='PAN Number']")
private WebElement pan;
@FindBy(xpath="//input[@placeholder='Citizenship Number']")
private WebElement citizen;
@FindBy(xpath="//input[@placeholder='Home Address']")
private WebElement homeaddress;
@FindBy(xpath="//input[@placeholder='Office Address']")
private WebElement officeaddress;
@FindBy(xpath="//input[@placeholder='US']")
private WebElement country;
@FindBy(xpath="//select[@name='state']")
private WebElement state;
@FindBy(xpath="//select[@name='city']")
private WebElement city;
@FindBy(xpath="//input[@placeholder='Pin Code']")
private WebElement pincode;
@FindBy(xpath="//input[@placeholder='Area/Locality']")
private WebElement arealocality;
@FindBy(xpath="//input[@placeholder='Nominee Name (If any)']")
private WebElement nominee;
@FindBy(xpath="//input[@placeholder='Nominee Account no']")
private WebElement nomineeAccount;
@FindBy(xpath="//select[@name='acctype']")
private WebElement accounttype;
@FindBy(xpath="//input[@name='submit']")
private WebElement submitbutton;
@FindBy(xpath="//input[@value=\"Confirm\"]")
private WebElement confirmbtm;
public WebElement getconfirmbtm()
{
	return confirmbtm;
}
public WebElement getName() {
	return name;
}
public WebElement getGender() {
	return gender;
}
public WebElement getMobileno() {
	return mobileno;
}
public WebElement getEmailid() {
	return emailid;
}
public WebElement getLandline() {
	return landline;
}
public WebElement getDob() {
	return dob;
}
public WebElement getPan() {
	return pan;
}
public WebElement getCitizen() {
	return citizen;
}
public WebElement getHomeaddress() {
	return homeaddress;
}
public WebElement getOfficeaddress() {
	return officeaddress;
}
public WebElement getCountry() {
	return country;
}
public WebElement getState() {
	return state;
}
public WebElement getCity() {
	return city;
}
public WebElement getPincode() {
	return pincode;
}
public WebElement getArealocality() {
	return arealocality;
}
public WebElement getNominee() {
	return nominee;
}
public WebElement getNomineeAccount() {
	return nomineeAccount;
}
public WebElement getAccounttype() {
	return accounttype;
}
public WebElement getSubmitbutton() {
	return submitbutton;
}
public OnlineAccountOpeningFromPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
WebDriverUtility wutil=new WebDriverUtility();
ExcelUtility exutil=new ExcelUtility();
JavaUtility jutil=new JavaUtility();


public String createAccount() throws Throwable
{
	String ownname=exutil.readDataFromExcel("accountdetails", 0, 1)+jutil.randomNum();
	name.sendKeys(ownname);
	gender.click();
	wutil.select(gender,exutil.readDataFromExcel("accountdetails", 1, 1));
	gender.click();
	mobileno.sendKeys(exutil.readDataFromExcel("accountdetails", 2, 1));
	emailid.sendKeys(exutil.readDataFromExcel("accountdetails", 3, 1));
	landline.sendKeys(exutil.readDataFromExcel("accountdetails", 4, 1));
	dob.click();
	dob.sendKeys(exutil.readDataFromExcel("accountdetails", 5, 1));
	pan.sendKeys(exutil.readDataFromExcel("accountdetails", 6, 1));
	citizen.sendKeys(exutil.readDataFromExcel("accountdetails", 7, 1));
	homeaddress.sendKeys(exutil.readDataFromExcel("accountdetails", 8, 1));
	officeaddress.sendKeys(exutil.readDataFromExcel("accountdetails", 9, 1));
	country.click();
	state.click();
	wutil.select(state, exutil.readDataFromExcel("accountdetails", 10, 1));
	state.click();
	city.click();
	wutil.select(city,exutil.readDataFromExcel("accountdetails", 11, 1));
	city.click();
	pincode.sendKeys(exutil.readDataFromExcel("accountdetails", 12, 1));
	arealocality.sendKeys(exutil.readDataFromExcel("accountdetails", 13, 1));
	nominee.sendKeys(exutil.readDataFromExcel("accountdetails", 14, 1)); 
	
	nominee.sendKeys(exutil.readDataFromExcel("accountdetails", 15, 1));
	accounttype.click();
	wutil.select(accounttype, exutil.readDataFromExcel("accountdetails", 16, 1));
	accounttype.click();
	submitbutton.click();
	confirmbtm.click();
	return ownname;
}


}
