package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import com.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage= new LoginPage();
	}
	
		
	@Test(description="Validate user is looged in by verifying the username label")
	public void VerifyUsernameLabelTest() throws InterruptedException
	{
		loginpage.loginemail(prop.getProperty("username"));
		loginpage.loginpass(prop.getProperty("password"));
		String actualuserinfo=loginpage.Userlogin1();
		String expecteduserinfo = "testuserxyz252@gmail.com";
	     Assert.assertEquals(actualuserinfo, expecteduserinfo);		
		
		}
	
	@Test(description="Validate user is looged in by verifying compose button is displayed")
	public void VerifyComposebuttonisDisplayed() throws InterruptedException
	{
		loginpage.loginemail(prop.getProperty("username"));
		loginpage.loginpass(prop.getProperty("password"));
		boolean actual=loginpage.Userlogin2();
		Assert.assertEquals(actual, true);	
				
	}
	
	@Test(description="Validate user is looged in by verifying the page title")
	public void VerifyLoginPageTitle() throws InterruptedException
	{
		loginpage.loginemail(prop.getProperty("username"));
		loginpage.loginpass(prop.getProperty("password"));
		String actualtitle=loginpage.Userlogin3();
		String expectedtitle="Inbox - testuserxyz252@gmail.com - Gmail";
		Assert.assertEquals(actualtitle, expectedtitle);
				
	}
	
    
	
	@DataProvider(name = "data")
    public Object[][] createData() {
     return new Object[][] {
       { "sahaiswat@gmail.com","hello","how are you" }
     };
    }
	
    @Test(description="Send an email", dataProvider="data") 
	public void sendmail (String email, String sub, String text) throws InterruptedException
	{
    	loginpage.loginemail(prop.getProperty("username"));
 		loginpage.loginpass(prop.getProperty("password"));
		loginpage.sendemail(email, sub, text);
	}
	
     

		
	@AfterMethod
	public void CloseApplication()
	{
		TearDown();
	}
	
}
