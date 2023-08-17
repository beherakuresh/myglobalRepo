package com.banking.onlinebanking.practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConnectTestyantraserver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("kuresh-onlinebanking");
		driver.findElement(By.name("createdBy")).sendKeys("vijayalaxmi");
		WebElement dropdown=driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		

	}

}
