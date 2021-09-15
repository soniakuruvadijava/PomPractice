package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.ElementUtil;

import io.qameta.allure.Step;

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
	
	@Step("Step: Getting Login Page title")
	public String LaunchPageTitle()
	{
		return Eleutil.waitForTitleContains("Online", 10);
	}
	
	@Step("Step: Click on Launch Sign In button ")
	public void clickonLaunchSignIn()
	{
		Eleutil.doClick(LaunchSignInButton);
	}
	
	@Step("Step: Enter UserName {0} in User name field  ")
	public void enterUserName(String UserName)
	{
		Eleutil.doSendKeys(SignInEmail, UserName);
	}
	
	@Step("Step: Click on Continue button after entering UserName")
	public void clickonContinue()
	{
		Eleutil.doClick(SignInContinue);
	}
	
	@Step("Step: Click on Continue button after entering UserName")
	public void enterPassword(String Password)
	{
		Eleutil.doSendKeys(SignInPassword, Password);
	}
	
	public void clickonSignIn()
	{
		Eleutil.doClick(SignInButton);
	}
	
	@Step("Step: Login with Valid Login and Password : {0} and {1}")
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
