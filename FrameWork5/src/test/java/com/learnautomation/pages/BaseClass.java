package com.learnautomation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
 public WebDriver driver;
 public ExcelDataProvider excel;
 public ConfigDataProvider config;
 public ExtentReports reports;
 public ExtentTest logger;
 
 @BeforeSuite
 public void setUpSuit()
 {
Reporter.log("Setting up Reports and Test getting ready",true);
	 
 excel = new ExcelDataProvider();	 
 config = new ConfigDataProvider();
  ExtentHtmlReporter extent = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html");
  reports = new ExtentReports();
  reports.attachReporter(extent);
Reporter.log("Setting Down Reports and Test can be Started", true);
 }
 @Parameters({"browser","urlToBeTested"})	
 @BeforeClass
 public void setup(String browser,String url)
 {
Reporter.log("Trying to Start Browser and Getting Application", true);	 
// driver = BrowserFactory.startApplication(driver,"chrome","https://classic.crmpro.com/index.html");
// driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getURL());
 driver = BrowserFactory.startApplication(driver,browser,url);
 
Reporter.log("Browser and Application can be up and running",true); 
 }
	
 @AfterClass
 public void tearDown()
 {
 BrowserFactory.quitBrowser(driver);	
 }

 //Failure Testcases capture screenshots
 @AfterMethod
public void tearDownMethod(ITestResult result) throws IOException
{
Reporter.log("Test is about to end", true);	 
if (result.getStatus()==ITestResult.FAILURE)
{
//Helper.captureScreenshot(driver);	
logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
}	
else if (result.getStatus()==ITestResult.SUCCESS)
{
logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	
}

reports.flush();
Reporter.log("Test Completed>>>Reports Generated", true);
}
	
	
	
	
}
