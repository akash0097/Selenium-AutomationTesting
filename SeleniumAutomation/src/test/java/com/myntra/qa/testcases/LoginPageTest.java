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
		System.out.println("**Open setUp LoginPageTest**");
		Reporter.log("Before Method - Open setUp");
		initialization();
		loginPage = new LoginPage();
		Reporter.log("Befgore Method - Close setUp");
		System.out.println("**Close setUp LoginPageTest**");
	}
	
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		System.out.println("**Test - Open verifyLoginPageTitleTest**");
		Reporter.log("Test - Open verifyLoginPageTitleTest");
		String loginPageTitlle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitlle, "Myntra" , "Login page title is not displayed as expected");
		Reporter.log("Test - close verifyLoginPageTitleTest");
		System.out.println("**Test - Close verifyLoginPageTitleTest**");
	}
	
	@Test(priority = 2)
	public void loginUserTest() {
		System.out.println("**Test - Open loginUserTest**");
		Reporter.log("Test - Open loginUserTest");
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		Reporter.log("Test - Close loginUserTest");
		System.out.println("**Test - Close loginUserTest**");
	}
	
	@AfterMethod
	public void closeDriver() {
		System.out.println("**Open closeDriver LoginPageTest**");
		Reporter.log("After Method - Open closedDriver");
		driver.quit();
		Reporter.log("After Method - Close closeDriver");
		System.out.println("**Close closeDriver LoginPageTest**");
	}
}
