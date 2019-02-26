package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

//alerts,windows,screenshots,sysissues,javascript exeplorer	
 public static String captureScreenshot(WebDriver driver)
 {
 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	 
 String screenshotpath = System.getProperty("user.dir")+"./Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
 
 //String screenshotpath = System.getProperty("user.dir")+"./Screenshots/FreeCRM_"+getCurrentDateTime()+"png";
 try {
	FileHandler.copy(src, new File(screenshotpath));
	System.out.println("Screenshot Captured");
}
 catch (IOException e)
 {
 System.out.println("Unable to Capture Screenshots>>"+e.getMessage());	
}
return screenshotpath;	
 }
 //Date and Time
public static String getCurrentDateTime()
{
DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
Date currentdate = new Date();
return customformat.format(currentdate);

}
	 
 
 }
	
	

