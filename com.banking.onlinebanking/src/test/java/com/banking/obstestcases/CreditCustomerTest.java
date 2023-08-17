package com.banking.obstestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreditCustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys("210001");
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.findElement(By.xpath("//input[@name='credit_cust_ac']")).click();
		 driver.findElement(By.xpath("//input[@name='customer_account_no']")).sendKeys("1011151011896");
		 driver.findElement(By.xpath("//input[@name='credit_amount']")).sendKeys("2000");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
	/*	 Alert a2=driver.switchTo().alert();
		 a2.getText();
		 a2.accept();  
		 */
		 WebDriverUtility wb=new WebDriverUtility();
		 wb.alertAccept(driver);
	     String ab= wb.alertgetText(driver);

	}

}
