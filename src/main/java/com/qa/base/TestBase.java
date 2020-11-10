package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class TestBase  {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	/**
	 * Code to pick up browser details for the config file 
	 * Initiate the browser driver 
	 * Launch the URL defined in the config file
	 * Pass username and password
	 * Browser, URL parameters, username and password passed from the config.properties file
	 */

	
	public TestBase() {
		
		prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream

					("C:\\Users\\ssinha\\eclipse-workspace\\Gmail\\src\\main\\java\\com\\qa\\config\\config.properties");
					try {
						prop.load(fis);
					} catch (FileNotFoundException e) {
							e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
					
			}

	
	public static void initialization()
	{
		prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ssinha\\\\Desktop\\\\driver\\\\chromedriver.exe");
		String osname =System.getProperty("os.name").toLowerCase();
		
		if (osname.contains("windows") && prop.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ssinha\\\\Desktop\\\\driver\\\\chromedriver.exe");
		} else if (osname.contains("mac os") && prop.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ssinha\\\\Desktop\\\\driver\\\\chromedriver.exe");
		}

	driver=new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("Browser is launched");
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	
}

	 public void waitForPageLoaded() {
		    ExpectedCondition<Boolean> expectation = new
		            ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
		                }
		            };
		    try {
		        Thread.sleep(2000);
		        WebDriverWait wait = new WebDriverWait(driver, 30);
		        wait.until(expectation);
		    } catch (Throwable error) {
		        Assert.fail("Timeout waiting for Page Load Request to complete.");
		   }
		  }
	
	public void TearDown()
	{
		driver.quit();
		System.out.println("Test Case is completed");
	}

}
