package com.banking.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.banking.pom.Homepage;
import com.banking.pom.StaffHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	
		DatabaseUtility dLib= new DatabaseUtility();
		PropertyUtility fLib=new PropertyUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility WLib=new WebDriverUtility();
		public WebDriver driver;
		public static WebDriver sdriver;
		@BeforeSuite(alwaysRun = true)
		public void congig_BS() throws Throwable
		{    
			dLib.connectDB();
			System.out.println("CONNECT TO Database");
		}
		
		@Parameters("Browser")
		@BeforeClass(alwaysRun = true)
		public void congig_BC() throws Throwable
		{ 
			String BROSWER=fLib.getProperty("browser");
			if(BROSWER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			System.out.println("launch the broswer");
			sdriver=driver;
			WLib.maximize(driver);
			
		}
		@BeforeMethod(alwaysRun = true)
		public void config_BM() throws Throwable
		{
		 String USERNAME=fLib.getProperty("username");
		 String PASSWORD=fLib.getProperty("password");
		 String URL=fLib.getProperty("url");
			
		 driver.get(URL);
		 Homepage hm=new Homepage(driver);
		 hm.clickonOpenAccount();
		 WLib.impwait(driver,10);
		
		 hm.clickonStaffLogin();
		}
		
		@AfterMethod(alwaysRun = true)
		public void Config_AM()
		{
		StaffHomePage sfh= new StaffHomePage(driver);
		sfh.clickOnLogoutbtn();
		
		System.out.println("--logout of the application--");
		}
		@AfterClass(alwaysRun = true)
		public void config_AC()
		{
			driver.quit();
			System.out.println("--close the broswer--");
		}
		@AfterSuite(alwaysRun = true)
		public void config_AS() throws Throwable
		{
			dLib.closeDb();
		
	}
	

}
