package com.banking.obstestcases;

import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.PropertyUtility;
import com.banking.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingLoginTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		PropertyUtility putil=new PropertyUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String browser=putil.getProperty("browser");
		String url=putil.getProperty("url");
		String staffid=putil.getProperty("staffid");
		String password=putil.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		
//		wutil.launchChrome(driver);
		driver.get(url);
		wutil.impwait(driver, 10);
		wutil.maximize(driver);
		
		Random r=new Random();
		int rr=jutil.randomNum();
		driver.findElement(By.xpath("//li[.='Open Account']")).click();
		String name="kureshbehera"+rr;
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		WebElement drop=driver.findElement(By.xpath("//select[@name='gender']"));
		drop.click();
		wutil.select(drop, "Male");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9777117511");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("beherakuresh1995@gmail.com");
		driver.findElement(By.xpath("//input[@name='landline']")).sendKeys("0674-123456");
		WebElement dob=driver.findElement(By.xpath("//input[@name='dob']"));
		dob.click();
		dob.sendKeys("25/05/1990");
		driver.findElement(By.xpath("//input[@name='pan_no']")).sendKeys("bhbpb9079d");
		driver.findElement(By.xpath("//input[@name='citizenship']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='homeaddrs']")).sendKeys("murgeshpalya");
		driver.findElement(By.xpath("//input[@name='officeaddrs']")).sendKeys("testyantra");
		WebElement state=driver.findElement(By.xpath("//select[@name='state']"));
		state.click();
		wutil.select(state, "Florida");
		WebElement city = driver.findElement(By.xpath("//select[@name='city']"));
		city.click();
		wutil.select(city, "Texas City");
		driver.findElement(By.xpath("//input[@name='pin']")).sendKeys("789456");
		driver.findElement(By.xpath("//input[@name='arealoc']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys("ramakrishna");
		driver.findElement(By.xpath("//input[@name='nominee_ac_no']")).sendKeys("4562589");
		WebElement ac = driver.findElement(By.xpath("//select[@name='acctype']"));
		ac.click();
		wutil.select(ac, "Saving");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		
		String al=wutil.alertgetText(driver);
		String output="";
		//fetch numeric value from alert popup
		
		for(int i=0;i<al.length();i++) {
		
		char a = al.charAt(i);
		
		 if(Character.isDigit(a))
		{
			 output=output+a;
			
		}
		}
		System.out.println(output);
		wutil.alertAccept(driver);
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffid);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		driver.findElement(By.xpath("//input[@name='apprvac']")).click();
		driver.findElement(By.xpath("//input[@name='application_no']")).sendKeys(output);
		driver.findElement(By.xpath("//input[@name='search_application']")).click();
		driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
		Thread.sleep(5000);
		
		String ss=wutil.alertgetText(driver);
		String m="";
		for(int i=0;i<ss.length();i++)
		{
			char cr=ss.charAt(i);
			if(Character.isDigit(cr))
			{
				m=m+cr;
			}
		}
		System.out.println("Accoutn no-"+m);
		wutil.alertAccept(driver);
		driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
		driver.findElement(By.xpath("//a[.='Home']")).click();
		
		driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();
		driver.findElement(By.xpath("//input[@name='holder_name']")).sendKeys(name);
		WebElement dobb=driver.findElement(By.xpath("//input[@name='dob']"));
		dobb.click();
		dobb.sendKeys("25/05/1990");
		driver.findElement(By.xpath("//input[@name='pan']")).sendKeys("bhbpb9079d");
		driver.findElement(By.xpath("//input[@name='mob']")).sendKeys("9777117511");
		driver.findElement(By.xpath("//input[@name='acc_no']")).sendKeys(m);
		driver.findElement(By.xpath("//input[@name='dbt_crd_submit']")).click();
		
		String alttt=wutil.alertgetText(driver);
		String mmm="";
		for(int i=0;i<alttt.length();i++)
		{
			char ccc=alttt.charAt(i);
			if(Character.isDigit(ccc) )
			{
				
				mmm=mmm+ccc;
				if(alttt.charAt(i+1) ==' ')
					mmm=mmm+' ';
				
			}
		}
		String debi = mmm.split(" ")[0];
		String debiPin = mmm.split(" ")[1];
		System.out.println(mmm);
		System.out.println(debi);
		System.out.println(debiPin);
		wutil.alertAccept(driver);
		driver.findElement(By.xpath("//a[.='Home']")).click();
		Actions act=new Actions(driver);
		WebElement ibanking=driver.findElement(By.xpath("//div[@class='ebanking']/.."));
		
		act.moveToElement(ibanking).perform();
		driver.findElement(By.xpath("//li[.='Register']")).click();
		driver.findElement(By.xpath("//input[@name='holder_name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='accnum']")).sendKeys(m);
		driver.findElement(By.xpath("//input[@name='dbtcard']")).sendKeys(debi);
		driver.findElement(By.xpath("//input[@name='dbtpin']")).sendKeys(debiPin);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9777117511");
		driver.findElement(By.xpath("//input[@name='pan_no']")).sendKeys("bhbpb9079d");
		WebElement mdob=driver.findElement(By.xpath("//input[@name='dob']"));
		mdob.click();
		mdob.sendKeys("25/05/1990");
		driver.findElement(By.xpath("//input[@name='last_trans']")).sendKeys("0");
		String mpassword="kuresh@123";
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(mpassword);
		driver.findElement(By.xpath("//input[@name='cnfrm_password']")).sendKeys(mpassword);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		String k1=wutil.alertgetText(driver);
		String m1="";
		for(int i=0;i<k1.length();i++)
		{
			char c1=k1.charAt(i);
			if(Character.isDigit(c1))
			{
				m1=m1+c1;
				
			}
		}
		System.out.println("customerid----"+m1);
		wutil.alertAccept(driver);
		driver.findElement(By.xpath("//a[.='Home']")).click();
		
		
		
		
	//	
		Thread.sleep(2000);
		driver.navigate().refresh();
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_PAGE_DOWN);
		
		//act.moveToElement(ibanking).perform();
		WebElement x=driver.findElement(By.partialLinkText("Internet Banking"));
		act.moveToElement(x).perform();
		WebElement log=driver.findElement(By.xpath("//li[.='Login ']"));
		//driver.navigate().refresh();
		log.click();
		driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys(m1);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(mpassword);
		driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		System.out.println("successful");
		
		
		
	}

}
