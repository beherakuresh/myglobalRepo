package com.banking.obstestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.GenericUtility.PropertyUtility;
import com.banking.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCustomerTest {

	public static void main(String[] args) throws IOException, Throwable {
		// TODO Auto-generated method stub
		for(int i=0;i<2;i++) {
		PropertyUtility putil=new PropertyUtility();
		WebDriverUtility wutility=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		wutility.impwait(driver, 10);
		
		String url=putil.getProperty("url");
		driver.get(url);
		wutility.maximize(driver);
		
        String username=putil.getProperty("username");
		String password=putil.getProperty("password");
		
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.findElement(By.xpath("//input[@name='viewdet']")).click();
		 
		 String customerid=driver.findElement(By.xpath("//tr[\"1\"]/descendant::td[3]")).getText();
		 System.out.println(customerid);
		 String accountno=driver.findElement(By.xpath("//tr[\"1\"]/descendant::td[4]")).getText();
		 System.out.println(accountno);
		 driver.findElement(By.xpath("//input[@name='home']")).click();
		 driver.findElement(By.xpath("//input[@name='del_cust']")).click();
		 driver.findElement(By.xpath("//input[@name='Cust_ac_no']")).sendKeys(accountno);
		 driver.findElement(By.xpath("//input[@name='Cust_ac_Id']")).sendKeys(customerid);
		 driver.findElement(By.xpath("//input[@name='reason']")).sendKeys("clear");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@name='delete']")).click();
		 Thread.sleep(2000);
		 try {
		 wutility.alertgetText(driver);
		 
		 
		 wutility.alertAccept(driver);
		 }
		 catch (Exception e) {
				// TODO: handle exception
			}
		 driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		 driver.findElement(By.xpath("//input[@name='view_cust_by_ac']")).click();
		 driver.findElement(By.xpath("//input[@name='account_no']")).sendKeys("1011951011347");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.quit();
	}
		

}
}
