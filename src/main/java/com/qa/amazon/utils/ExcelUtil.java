package com.qa.amazon.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtil {

	private WebDriver driver;
	
	public void clickElement(By locator)
	{
		driver.findElement(locator).click();
	}
	
	
}
