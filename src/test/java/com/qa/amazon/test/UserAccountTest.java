package com.qa.amazon.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.amazon.pages.UserAccountPage;

public class UserAccountTest extends BaseTest{

	@BeforeTest
	public void AccountPageSetup()
	{
		loginpage.clickonLaunchSignIn();
		String UserName = prop.getProperty("username") ;
		String Password =  prop.getProperty("password") ;
		accountpage = loginpage.dologin(UserName, Password);
	}
	
	@Test(priority=1)
	public void ValidatlogienUserName() {
	
		String UserName = accountpage.getloginUserName();
		System.out.println(UserName);
		Assert.assertEquals(UserName, UserName);
	}
	
	@Test(priority=2)
	public void ValidateCartCount() {
		String CartCount = accountpage.getCartCount();
		System.out.println(CartCount);
		Assert.assertEquals(CartCount, CartCount);
	}
	
	
	
	
	
}
