package com.banking.onlinebanking.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginApplicationUseingDatafromPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\k.properties");
		 Properties pobj = new Properties();
		 pobj.load(fis);
		 WebDriver driver;
		 String browser=pobj.getProperty("browser");
		 String u=pobj.getProperty("url");
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 driver.get(u);
			 driver.manage().window().maximize();
			 
		 }
		 else if(browser.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 driver.get(u);
			 driver.manage().window().maximize();
			 
		 }
		 else
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 driver.get(u);
			 driver.manage().window().maximize();
		 }
		 
		 
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys(pobj.getProperty("username"));
		 driver.findElement(By.xpath("//input[@class='password']")).sendKeys(pobj.getProperty("password"));
		 driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		 
		 
		 

	}

}
