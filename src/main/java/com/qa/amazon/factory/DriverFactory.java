package com.qa.amazon.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		

		String BrowserName = prop.getProperty("browser");
		highlight = prop.getProperty("highlight");
		System.out.println("Browser name is:" + BrowserName);
		
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			
		} else if (BrowserName.equalsIgnoreCase("FrieFox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		} else
			System.out.println("Please enter proper browser type");

		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	
	
	public WebDriver getDriver()
	{
		return tlDriver.get();
	}
	/**
	 * This method is used to initialise the propeties for given environment
	 * @return 
	 */

	public Properties initproperties()

	{
		Properties prop = null;
		try {
			
			FileInputStream inputfile = new FileInputStream(".\\src\\test\\resources\\config\\cofig.properties");
			 prop = new Properties();
			prop.load(inputfile);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No File not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

	/*
	 * Take screenshot
	 */
	
	public String getScreenshot()
	{
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenhot/"+System.currentTimeMillis()+".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile,destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
		
	}
}
