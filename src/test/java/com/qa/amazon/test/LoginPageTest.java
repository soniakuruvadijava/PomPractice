package com.qa.amazon.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.amazon.pages.UserAccountPage;
import com.qa.amazon.utils.ApplicationConstents;
import com.qa.amazon.utils.ApplicationError;
import com.qa.amazon.test.*;	

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic: 001 - Design login page for Amazon ...")
@Story("JIRA # 101 : Amazon valid login name ... ")
public class LoginPageTest extends BaseTest{

	@Description("This Test will validate Launch page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void getTitle()
	{
	String amazonString	= loginpage.LaunchPageTitle();
	System.out.println(amazonString);
	Assert.assertEquals(amazonString, ApplicationConstents.Login_Page_Title,ApplicationError.TITLE_ERROR_MSG);
	}
	
	@Description("This Test will click on SignIn Button")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void clickLaunchSignIn()
	{
		loginpage.clickonLaunchSignIn();
		
	}
	
	/*
	 * @Test public UserAccountPage enterUserName() {
	 * loginpage.enterUserName(prop.getProperty("username"));
	 * loginpage.clickonContinue();
	 * loginpage.enterPassword(prop.getProperty("password"));
	 * loginpage.clickonSignIn();
	 * 
	 * return new UserAccountPage(driver); }
	 */
	
	@Description("This Test will Login with valid Login details")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void LoginValidDetails()
	{
		String UserName = prop.getProperty("username") ;
		String Password =  prop.getProperty("password") ;
		UserAccountPage account = loginpage.dologin(UserName, Password);
		System.out.println(account.getloginUserName());
		Assert.assertEquals(account.getloginUserName(), account.getloginUserName());
		
	}
}
