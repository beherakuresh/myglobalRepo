package com.banking.onlinebanking.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromCmdLineTest {
	@Test
	public void readDataFromCmd()
	{
		//String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
	}
	

}
