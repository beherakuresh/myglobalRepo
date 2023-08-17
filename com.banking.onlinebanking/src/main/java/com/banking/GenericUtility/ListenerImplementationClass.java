package com.banking.GenericUtility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementationClass implements ITestListener   //Itestlistener is a interface
{
	ExtentReports report;
	ExtentTest test;
	public void onTestSuccess(ITestResult result) 
	{
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS,methodname+"..................>passed");
		Reporter.log(methodname+".............>TestScript passed");//this line is optional
		
	
	
	}

	public void onTestFailure(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		String failedscript=methodname+new JavaUtility().getSystemDateInFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File trg=new File("./myScreenshots/failed.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		test.log(Status.FAIL, failedscript+"................>fialed");
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(trg.getAbsolutePath());
		Reporter.log(failedscript+".................>testScript failed");//this line is optional
		
		
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodname=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"......>skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodname+".....................>testScriptSkipped");//this line is optional
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) 
	{	
		ExtentSparkReporter esp = new ExtentSparkReporter("./TestngReport/report.html");
		esp.config().setDocumentTitle("kureshBehera");
		esp.config().setTheme(Theme.DARK);
		esp.config().setReportName("onlineBanking");
		
		
		report = new ExtentReports();
		report.attachReporter(esp);
		report.setSystemInfo("operating System", "windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("base-url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
		report.setSystemInfo("reporter-name", "bigboss");		
		
	}

	

	public void onFinish(ITestContext context)
	{
		
	report.flush();
	}

	public void onTestStart(ITestResult result) 
	{
		//execution start from this method
		String methodname=result.getMethod().getMethodName();
		test = report.createTest(methodname);
		Reporter.log(methodname+"test script execution start");//this line is optional
		
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	
}
