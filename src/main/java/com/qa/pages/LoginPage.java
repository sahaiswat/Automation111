package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;


public class LoginPage extends TestBase{


	// Defining locators using Page Factory
	
	//locator for email id
	
	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement emailid;
	
	//locator for next button on email input page
	
	@FindBy(id= "identifierNext")
	WebElement nextbutton1;
	
	//locator for password
	
	@FindBy (xpath= "//input[@name='password']")
	WebElement password;
	
	//locator for next button on password input page
	
	@FindBy(id= "passwordNext")
	WebElement nextbutton2;
	
	//locator for compose button
	
	@FindBy(className = "z0")
	WebElement compose;
	
	//locator for "To" recipient 
	
	@FindBy(className = "vO")
	WebElement recipients;
	
	//locator for subject  
	
	@FindBy(className = "aoT")
	WebElement subject;
	
	//locator for body of the email
	
	@FindBy(className = "Am")
	WebElement body;
	
	//locator for send button for sending mail
	
	@FindBy(className = "aoO")
	WebElement sendbutton;
	
	// locator for user logo 
	
	@FindBy (xpath="//img[@class='gb_Ia gbii']")
	WebElement userlogo;
	
	//locator for username
	
	@FindBy(xpath = "//div[@class='gb_sb'][contains(.,'testuserxyz252@gmail.com')]")
	WebElement username;
		
		
	// Initializing the locators
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Method for passing email id and clicking next button
	
	public  void loginemail (String email)  
	 {
		
		emailid.sendKeys(email);
		nextbutton1.click();
				 
	 }
	
	// Method for passing password and clicking next button
	
	public  void loginpass (String pass) throws InterruptedException  
	 {
		
	  //Thread.sleep(1000);
		waitForPageLoaded();
		password.sendKeys(pass);
		nextbutton2.click();
		waitForPageLoaded();
	   // Thread.sleep(2000);
						 
	 }
	
	// Method for validating user login by getting text of the user
	
	public String Userlogin1()
	{
		waitForPageLoaded();
		userlogo.click();
		String text= username.getText();
		return text;
	}
	
	// Method for validating user is logged in by showing compose button is displayed
	
	public boolean Userlogin2() throws InterruptedException
	{
		//Thread.sleep(1000);
		waitForPageLoaded();
		return compose.isDisplayed();
		
	}
	
	// Method for validating user login by getting title of the page
	
	public String Userlogin3()
	{
		waitForPageLoaded();
		return driver.getTitle();
		
	}
	
	// Method to send an email
	
	public  void sendemail (String emailid, String sub, String text) throws InterruptedException  
	 {
		//Thread.sleep(3000);
		waitForPageLoaded();
		compose.click();
		recipients.sendKeys(emailid);
		subject.sendKeys(sub);
		body.sendKeys(text);
		sendbutton.click();
		waitForPageLoaded();
				 
	 }
	
	

}
