package com.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	
	public void switchBrowser(String browser)
	{
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resorces/geckodriver.exe");
			 driver = new FirefoxDriver();
		}else{
			System.setProperty("webdriver.chrome.driver","src/main/resorces/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	@Test
	public void validateTitle()
	{
		String url= "http://demo.guru99.com/selenium/newtours/";
		String expectedTitle="Welcome: Mercury Tours";
		String actualTitle;

		driver.get(url);
		actualTitle= driver.getTitle();
		if(expectedTitle != actualTitle)
		{
			System.out.println("not matched");
		}else
			System.out.println("title matched");
	}

	@Test
	public void fbTest()
	{

		String baseUrl = "http://www.facebook.com";
		String tagName = "";

		driver.get(baseUrl);
		tagName = driver.findElement(By.id("email")).getTagName();
		System.out.println(tagName);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
