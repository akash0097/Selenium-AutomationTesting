package com.myntra.qa.testcases;

import org.testng.Assert;
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
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String loginPageTitlle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitlle, "Myntra" , "Login page title is not displayed as expected");
	}
	
	@Test(priority = 2)
	public void loginUserTest() {
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}
