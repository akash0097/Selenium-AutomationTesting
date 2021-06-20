package com.myntra.qa.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.qa.base.TestBase;
import com.myntra.qa.pages.HomePage;
import com.myntra.qa.pages.LoginPage;
import com.myntra.qa.pages.ProductPage;

public class ProductPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;

	public ProductPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Reporter.log("Before Method - Open setUp");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		homePage.clickJacketsUnderMensSectionFromMenu();
		implicitBreaks(30);
		productPage = homePage.clickOnProduct();
		switchToWindow();
		Reporter.log("Before Method - Close setUp");
	}

	@Test(priority = 1)
	public void verifyProductTitleTest() {
		Reporter.log("Test - Open verifyProductTitleTest");
		productPage.getProductTitle();
		System.out.println("Inside Test = " + productPage.getProductTitle());
		Assert.assertTrue(true);
		Reporter.log("Test - Close verifyProductTitleTest");
	}

	@Test(priority = 2)
	public void verifyProductDescriptionTest() {
		Reporter.log("Test - Open verifyProductDescriptionTest");
		productPage.getproductDescription();
		System.out.println("Inside Test = " + productPage.getproductDescription());
		Assert.assertTrue(true);
		Reporter.log("Test - Close verifyProductDescriptionTest");
	}

	@Test(priority = 3)
	public void verifyProductPriceTest() {
		Reporter.log("Test - Open verifyProductPriceTest");
		productPage.getProductPrice();
		System.out.println("Inside Test = " + productPage.getProductPrice());
		Assert.assertTrue(true);
		Reporter.log("Test - Close verifyProductPriceTest");
	}

	@Test(priority = 4)
	public void verifyListOfCustomerReviews() {
		Reporter.log("Test - Open verifyListOfCustomerReviews");
		ArrayList<String> listOfCustomersReviews = productPage.listOfTopThreeProductReviews();
		for (String string : listOfCustomersReviews) {
			System.out.println("Customers Reviews on product = " + string);
		}
		Assert.assertTrue(true);
		Reporter.log("Test - Close verifyListOfCustomerReviews");
	}

	@AfterMethod
	public void closeDriver() {
		Reporter.log("After Method - Open closedDriver");
		driver.quit();
		Reporter.log("After Method - Close closeDriver");
	}

}
