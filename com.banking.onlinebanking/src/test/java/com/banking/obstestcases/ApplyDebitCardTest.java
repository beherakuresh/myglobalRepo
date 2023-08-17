package com.banking.obstestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.banking.GenericUtility.ExcelUtility;
import com.banking.GenericUtility.PropertyUtility;
import com.banking.GenericUtility.WebDriverUtility;
import com.banking.pom.ApplyDebitCardHomePage;
import com.banking.pom.EnterApplicationNumHomePage;
import com.banking.pom.Homepage;
import com.banking.pom.InternetBankingRegistrationPage;
import com.banking.pom.OnlineAccountOpeningFromPage;
import com.banking.pom.StaffHomePage;
import com.banking.pom.StaffLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyDebitCardTest {
	

	public static void main(String[] args) throws Throwable {
		WebDriver driver =null;
		WebDriverUtility wutility=new WebDriverUtility();
		PropertyUtility putility=new PropertyUtility();
		ExcelUtility exutil = new ExcelUtility();
		OnlineAccountOpeningFromPage pm=new OnlineAccountOpeningFromPage(driver);
		InternetBankingRegistrationPage ibrp=new InternetBankingRegistrationPage(driver);
		
		Homepage hp=new Homepage(driver);
		String url=putility.getProperty("url");
		String staffid=putility.getProperty("staffid");
		String password=putility.getProperty("password");

		String mobile=exutil.readDataFromExcel("accountdetails", 2, 1);
		String pan=exutil.readDataFromExcel("accountdetails", 6, 1);
		String mypassword=exutil.readDataFromExcel("accountdetails", 17, 1);
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		

		driver.get(url);
		wutility.impwait(driver,10);
		wutility.maximize(driver);
		
		hp.clickonOpenAccount();
		
		
		String ownname=pm.createAccount();
		Thread.sleep(5000);
		String alt=wutility.alertgetText(driver);
	
		String my="";
		for(int i=0;i<alt.length();i++)
		{
		char ch=alt.charAt(i);
			if(Character.isDigit(ch) )
			{
				
				my=my+ch;
			}
			
		}
		
		wutility.alertAccept(driver);	
		hp.clickonStaffLogin();
		StaffLoginPage sfp=new StaffLoginPage(driver);
		sfp.staffLogin(staffid, password);
		StaffHomePage shp=new  StaffHomePage(driver);
		shp.aprovePendingAccount();
		EnterApplicationNumHomePage eap=new EnterApplicationNumHomePage(driver);
		eap.approve(my);
		
		String alt1=wutility.alertgetText(driver);
		String accountNo="";
		for(int i=0;i<alt1.length();i++)
		{
			char ch=alt1.charAt(i);
			if(Character.isDigit(ch))
			{
				accountNo=accountNo+ch;
			}
		}
		wutility.alertAccept(driver);
		System.out.println("account number is--------->"+accountNo);
		eap.clickOnHome();
		hp.clickonApplydebitcard();
		ApplyDebitCardHomePage adch=new ApplyDebitCardHomePage(driver);
		adch.applydebitcard(ownname, accountNo);
		String alt2=wutility.alertgetText(driver);
		String debit="";
		for(int i=0;i<alt2.length();i++)
		{
			char ch=alt2.charAt(i);
			if(Character.isDigit(ch))
			{
				debit=debit+ch;
			}
		}
		wutility.alertAccept(driver);
		String debitc=debit.substring(0,debit.length()-4);
		String pin=debit.substring(debitc.length(),debit.length());
		System.out.println(debit);
		System.out.println(debitc);
		System.out.println(pin);
		adch.clickOnHome();
		hp.clickOninternetBankingRegister(driver);
		OnlineAccountOpeningFromPage oaof=new OnlineAccountOpeningFromPage(driver);
		String ownname1=oaof.createAccount();
		ibrp.InternetBankingRegister(ownname1,accountNo , debitc, pin, mobile, pan, mypassword);
		
		

		
		
		
		
		
		
		
		
		
		
	}

}
