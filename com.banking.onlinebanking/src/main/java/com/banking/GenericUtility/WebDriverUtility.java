package com.banking.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
public void maximize(WebDriver driver)

{
	driver.manage().window().maximize();
}
public void impwait(WebDriver driver,int time)
{
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	
}
public void waitUntilWebelementVisible(WebDriver driver,int seconds,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
public void select(WebElement element,int index)
{
	Select s=new Select(element);
	s.selectByIndex(index);
}
public void select(WebElement element,String text)
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
public void select(String value,WebElement element)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
public String printAlloptions(WebElement element)
{
	String s=null;
	Select s1=new Select(element);
	List<WebElement>all=s1.getOptions();
	for(WebElement al:all)
	{
		 s=al.getText();
		//System.out.println(s);
	}
	return s;
}
	/**
	 * this method will perform mouseHover action
	 * @throws InterruptedException 
	 */
public void mouseHovering(WebDriver driver,WebElement element) throws InterruptedException
{
	Thread.sleep(5000);
	Actions act=new Actions(driver);
	act.moveToElement(element).click().build().perform();
	
}
/*
 * this method will perform drag and drop
 */
public void dragAnddrop(WebDriver driver,WebElement source,WebElement target)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(source, target).perform();
}
/*
 * this method will perform doubleclick
 */
public void doubleclick(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/*
 * this method will perform rightclick operation on webpage
 */
public void rightClick(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
/*@author kB
 * this method will perform right click on webelement
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
		/**
		 * this method will take the screenshot of entir webpage
		 * @throws IOException 
		 * @throws  
		 */
public void takeWScreenshotWebpage(WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("");
	FileUtils.copyFile(src, trg);
	
	
}
/**
 * this method will take the screenshot of particular webelement
 * @throws IOException 
 * @author kb
 */
public void takeScreenshotWebelement(WebDriver driver,WebElement element) throws IOException
{
	File src=element.getScreenshotAs(OutputType.FILE);
	File trg=new File("");
	FileUtils.copyFile(src, trg);
}
/**
 * this method is used to switch to alert popup
 * @return 
 */
public String alertgetText(WebDriver driver)
{
	Alert alt=driver.switchTo().alert();
	String text = alt.getText();
	return text;
}
/**
 * this method is used to accept the alert popup
 */
public void alertAccept(WebDriver driver)
{
	Alert alt=driver.switchTo().alert();
	alt.accept();
}

public WebDriver launchChrome(WebDriver driver)
{
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 return driver;

}
public void pageScrolling() throws AWTException
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_PAGE_DOWN);
	r.keyRelease(KeyEvent.VK_PAGE_DOWN);
}

	
}

