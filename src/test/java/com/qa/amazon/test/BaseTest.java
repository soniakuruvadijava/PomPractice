package com.qa.amazon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.amazon.factory.DriverFactory;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.UserAccountPage;

public class BaseTest {

	WebDriver driver;
	WebDriver driver1;
	DriverFactory df;
	Properties prop;
	
	LoginPage loginpage;
	UserAccountPage accountpage;
	
	@BeforeTest
	public void SetUp() {
		
	df = new DriverFactory();
	prop=df.initproperties();
	driver = df.initDriver(prop);
	//driver1 = df.initDriver("chrone");
	
	loginpage = new LoginPage(driver);
	
	}
	
	@AfterTest
	public void TearDown() {
	//	driver.quit();
	}
}
