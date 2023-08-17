package com.banking.onlinebanking.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement>all=driver.findElements(By.tagName("a"));
		System.out.println(all.size());
		int count=0;
		for(int i=0;i<all.size();i++)
		{
			WebElement element=all.get(i);
			String url=element.getAttribute("href");

			
			try {
				
				URL u=new URL(url);
			HttpURLConnection http=(HttpURLConnection)u.openConnection();
			
		//	http.connect();
			
			int res=http.getResponseCode();
			
			if(res>=400)
			{
				System.out.println("these are broken links-------");
				System.out.println(url);
				count++;
			}
			
			
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		System.out.println("number of deadlinks are"+count);
		
		
		
	}

}
