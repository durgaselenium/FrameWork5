package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
WebDriver driver;

//constructor
public LoginPage(WebDriver ldriver)
{
this.driver=ldriver;	
}

@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
@FindBy(name="password")WebElement pass;
@FindBy(xpath="//input[@type='submit'][@value='Login']")WebElement loginButton;

public void loginToCRM(String usernameapplication, String passwordapplication)
{
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	
}	
uname.sendKeys(usernameapplication);
pass.sendKeys(passwordapplication);
loginButton.click();
}
}
