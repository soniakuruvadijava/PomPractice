package com.qa.amazon.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.amazon.pages.UserAccountPage;
import com.qa.amazon.listners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic: 002 - Design Account  page for Amazon ...")
@Story("JIRA # 102 : Amazon Acount login name ... ")
@Listeners(TestAllureListener.class)

public class UserAccountTest extends BaseTest{

	@Description("Account page test with login : Precondition")
	@Severity(SeverityLevel.BLOCKER)
	
	@BeforeTest
	public void AccountPageSetup()
	{
		loginpage.clickonLaunchSignIn();
		String UserName = prop.getProperty("username") ;
		String Password =  prop.getProperty("password") ;
		accountpage = loginpage.dologin(UserName, Password);
	}
	@Description("Account page test with login")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=1)
	public void ValidatlogienUserName() {
	
		String UserName = accountpage.getloginUserName();
		System.out.println(UserName);
		Assert.assertEquals(UserName, UserName);
	}
	@Description("Account page test with login")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void ValidateCartCount() {
		String CartCount = accountpage.getCartCount();
		System.out.println(CartCount);
		Assert.assertEquals(CartCount, CartCount);
	}
	
	
	
	
	
}
