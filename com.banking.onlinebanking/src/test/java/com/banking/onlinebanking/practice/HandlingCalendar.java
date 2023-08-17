package com.banking.onlinebanking.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCalendar {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='sc-12foipm-33 djFwsb'])[3]")).click();
		for(int i=0;i<5;i++)
		{
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		
	}
		driver.findElement(By.xpath("//div[.='January 2024']/ancestor::div[@class='DayPicker-Month']//p[.='1']")).click();
	}

}
