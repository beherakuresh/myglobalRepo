package com.banking.onlinebanking.practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarpopupMakemytrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
			driver.navigate().refresh();
		driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/railways/']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='travelDate']")).click();
		String month="August";
		int year = 2023;
		
	driver.findElement(By.xpath("(//div[.='"+month+" "+year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='10']")).click();
		//driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[2]/ancestor::div[@class='DayPicker-Month']/descendant::p[.='18'")).click();
	}
	
	

}
