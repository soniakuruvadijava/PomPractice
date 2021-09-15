package com.qa.amazon.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	public OptionsManager OptionsManager;
	public Properties prop;
	public WebDriver initDriver(Properties prop) {
		this.prop = prop;

		String BrowserName = prop.getProperty("browser");
		highlight = prop.getProperty("highlight");
		System.out.println("Browser name is:" + BrowserName);
		OptionsManager = new OptionsManager(prop);
		
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if(Boolean.parseBoolean(prop.getProperty("remote")))
			{
				init_RemortDriver("chrome");
			}
			else
			tlDriver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
			}
		else if (BrowserName.equalsIgnoreCase("FrieFox")) {
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
	
	
	
	private void init_RemortDriver(String browserName) {
		System.out.println("in Init_remortDriver" + browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		try {
			tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),caps ));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
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
		String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
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
