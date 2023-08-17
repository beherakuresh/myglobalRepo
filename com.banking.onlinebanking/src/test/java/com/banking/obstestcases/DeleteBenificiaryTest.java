package com.banking.obstestcases;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.PropertyUtility;
import com.banking.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteBenificiaryTest {

	public static void main(String[] args) throws Throwable {
	
		PropertyUtility putility=new PropertyUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		JavaUtility jutility=new JavaUtility();
		
		String url=putility.getProperty("url");
		String browser=putility.getProperty("browser");
		String staffid=putility.getProperty("staffid");
		String password=putility.getProperty("password");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wutility.maximize(driver);
		int rr=jutility.randomNum();
		driver.findElement(By.xpath("//li[.='Open Account']")).click();
		String name="kureshbehera"+rr;
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		WebElement drop=driver.findElement(By.xpath("//select[@name='gender']"));
		drop.click();
		wutility.select(drop, "Male");
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
		wutility.select(state, "Florida");
		WebElement city = driver.findElement(By.xpath("//select[@name='city']"));
		city.click();
	
		wutility.select(city, "Texas City");
		driver.findElement(By.xpath("//input[@name='pin']")).sendKeys("789456");
		driver.findElement(By.xpath("//input[@name='arealoc']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys("ramakrishna");
		driver.findElement(By.xpath("//input[@name='nominee_ac_no']")).sendKeys("4562589");
		WebElement ac = driver.findElement(By.xpath("//select[@name='acctype']"));
		ac.click();
		wutility.select(ac, "Saving");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		String al=wutility.alertgetText(driver);
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
		wutility.alertAccept(driver);
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(staffid);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		driver.findElement(By.xpath("//input[@name='apprvac']")).click();
		driver.findElement(By.xpath("//input[@name='application_no']")).sendKeys(output);
		driver.findElement(By.xpath("//input[@name='search_application']")).click();
		driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
		Thread.sleep(1000);
		
		String ss=wutility.alertgetText(driver);
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
		wutility.alertAccept(driver);
		driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
		driver.findElement(By.xpath("//a[.='Home']")).click();
		
	}

}
