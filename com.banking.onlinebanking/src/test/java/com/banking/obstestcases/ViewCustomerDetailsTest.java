package com.banking.obstestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.GenericUtility.PropertyUtility;
import com.banking.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewCustomerDetailsTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method 
		PropertyUtility putil=new PropertyUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String url=putil.getProperty("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wutil.impwait(driver, 10);
		driver.get(url);
		wutil.maximize(driver);
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		String username=putil.getProperty("username");
		String password=putil.getProperty("password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@name='viewdet']")).click();
		String abd= driver.findElement(By.xpath("//div[@class='active_customers_container']")).getText();
		System.out.println(abd);
				
	}

}
