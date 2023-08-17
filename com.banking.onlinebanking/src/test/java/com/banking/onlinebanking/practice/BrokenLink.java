package com.banking.onlinebanking.practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrokenLink {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/index.php");
		List<WebElement> alllinks=driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
		ArrayList<String> al=new ArrayList<String>();
		
		for(int i=0;i<alllinks.size();i++)
		{
			String link=alllinks.get(i).getAttribute("href");
			
			//System.out.println(link);
			//System.out.println(".................................");
			URL url=null;
			int statuscode=0;
			try 
			{
				
			url=new URL(link);
			HttpURLConnection http=(HttpURLConnection)url.openConnection();
		
			statuscode=http.getResponseCode();
			if(statuscode>=400)
			{
				al.add(link+".............."+statuscode);
				
			}
			}
			catch(Exception e)
			{
				al.add(link+"............"+statuscode);
			}
			System.out.println(al);
			
			
			}
			
		}

	}


