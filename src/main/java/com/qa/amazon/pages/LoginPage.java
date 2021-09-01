package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	ElementUtil Eleutil;
	
	// Locators
	private By LaunchSignInButton = By.xpath("//span[text()='Hello, Sign in']");
	private By SignInEmail = By.cssSelector("input[name='email']");
	private By SignInContinue = By.cssSelector("input#continue");
	private By SignInPassword = By.cssSelector("input[type='password']");
	private By SignInButton = By.cssSelector("input#signInSubmit");
	private By SignInForgotPasswordLink = By.linkText("  Forgot Password");
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
		Eleutil = new ElementUtil(this.driver);
		
	}
	
	public String LaunchPageTitle()
	{
		return Eleutil.waitForTitleContains("Online", 10);
	}
	
	public void clickonLaunchSignIn()
	{
		Eleutil.doClick(LaunchSignInButton);
	}
	
	public void enterUserName(String UserName)
	{
		Eleutil.doSendKeys(SignInEmail, UserName);
	}
	
	public void clickonContinue()
	{
		Eleutil.doClick(SignInContinue);
	}
	
	public void enterPassword(String Password)
	{
		Eleutil.doSendKeys(SignInPassword, Password);
	}
	
	public void clickonSignIn()
	{
		Eleutil.doClick(SignInButton);
	}
	
	public UserAccountPage dologin(String UserName, String Password)
	{
		
		Eleutil.waitForElementPresence(SignInEmail, 10);
		Eleutil.doSendKeys(SignInEmail, UserName);
		Eleutil.doClick(SignInContinue);
		
		Eleutil.waitForElementPresence(SignInPassword,10);
		Eleutil.doSendKeys(SignInPassword, Password);
		Eleutil.doClick(SignInButton);
		
		return new UserAccountPage(driver);
	}
	
	
}
