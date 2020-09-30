package com.qa.pages;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.testdata.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base{
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	@BeforeTest
	public void initialize() 
	{
		driver = initializeDriver();
	}

	@AfterTest
	public void teardown() throws IOException{
		getDriver().close();
		getDriver().quit();
	}
	/*
	public static WebDriver getDriver(){
		if(driver!=null)
		{
			return driver;
		}
		return null;
	}

	public void chromeoption()
	{

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
		driver= new ChromeDriver(options);

	}
	 */

	public WebDriver initializeDriver() 
	{
		/*if(Constants.browser.equals("chrome"))
		{
			chromeoption();
		}*/
		if(Constants.browser.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
		}
		else if (Constants.browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if (Constants.browser.equals("IE"))
		{
			//	IE code
		}
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().get(Constants.url);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {	
		return tlDriver.get();
	}

	// take screenshot:
		public String getScreenshot() {
			File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
		}
	
}
