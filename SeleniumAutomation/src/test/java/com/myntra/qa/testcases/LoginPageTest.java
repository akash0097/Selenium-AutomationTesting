package com.myntra.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.qa.base.TestBase;
import com.myntra.qa.pages.HomePage;
import com.myntra.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Reporter.log("Before Method - Open setUp");
		initialization();
		loginPage = new LoginPage();
		Reporter.log("Befgore Method - Close setUp");
	}
	
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		Reporter.log("Test - Open verifyLoginPageTitleTest");
		String loginPageTitlle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitlle, "Myntra" , "Login page title is not displayed as expected");
		Reporter.log("Test - close verifyLoginPageTitleTest");
	}
	
	@Test(priority = 2)
	public void loginUserTest() {
		Reporter.log("Test - Open loginUserTest");
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		Reporter.log("Test - Close loginUserTest");
	}
	
	@AfterMethod
	public void closeDriver() {
		Reporter.log("After Method - Open closedDriver");
		driver.quit();
		Reporter.log("After Method - Close closeDriver");
	}
}
