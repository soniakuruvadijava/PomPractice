package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.ElementUtil;

public class UserAccountPage {

	WebDriver driver;
	ElementUtil eleUtil;
	//Locators
	By UserLoginName = By.xpath("//div[@id='glow-ingress-block']/span[contains(.,'Deliver to')]");
	By Search = By.cssSelector("#twotabsearchtextbox");
	By AddToCart = By.cssSelector(".nav-cart-count");
	By SignOut =By.xpath("//span[contains(text(),'Sign Out')]");
	
	public UserAccountPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil = new ElementUtil(this.driver);
		
	}
	public String getloginUserName()
	{
		eleUtil.doIsDisplayed(UserLoginName);
		return eleUtil.doGetText(UserLoginName);
	}
	
	public String getCartCount()
	{
		eleUtil.doIsDisplayed(AddToCart);
		return eleUtil.doGetText(AddToCart);
	}
	
	
}
