package com.myntra.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.qa.base.TestBase;
import com.myntra.qa.pages.HomePage;
import com.myntra.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		Reporter.log("User Logged IN");
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		implicitBreaks(50);
		String homePageTitle = homePage.getHomePageTitle();
		System.out.println("Actual title = " + homePageTitle);
		Assert.assertEquals(homePageTitle, "Myntra", "Home Page title is not displayed as expected");
	}

	@Test(priority = 2)
	public void searchItemUsingSearchBoxTest() {
		String searchByText = "Kurtas";
		implicitBreaks(100);

		System.out.println("Page loadeded");

		homePage.clicksearchTextfield();
		implicitBreaks(10);

		homePage.setSearchField(searchByText);
		implicitBreaks(10);

		homePage.clickSearchFieldBtn();
		implicitBreaks(50);

		Assert.assertEquals(homePage.getSearchedItemLabel(), "Kurtas Online");
	}

	@Test(priority = 3)
	public void fliterItemsTest() {
		String searchBy = "Roadster";

		implicitBreaks(100);
		homePage.clickJacketsUnderMensSectionFromMenu();
		implicitBreaks(50);

		homePage.clickFilterSizeSelector();
		implicitBreaks(30);

		homePage.clickFilterSizeM();
		implicitBreaks(50);

		homePage.clickBrandSearchBtn();
		homePage.setBrandSearchField(searchBy);
		homePage.clickBrandSearchCheckBox();
		implicitBreaks(50);

		Assert.assertEquals(homePage.getSearchedItemLabel(), "Jackets For Men");
	}

	@Test(priority = 4)
	public void addItemsToWatchlistTest() {
		implicitBreaks(100);
		homePage.clickJacketsUnderMensSectionFromMenu();
		implicitBreaks(50);

		homePage.addItemToWatchList();
		implicitBreaks(30);

		System.out.println("After wish listing = " + homePage.getWatchlistedLabel());
		Assert.assertEquals(homePage.getWatchlistedLabel(), "WISHLISTED", "Selected item is not wish listed");
	}

	@Test(priority = 5 )
	public void removeItemFromWatchlistTest() {

		implicitBreaks(100);
		homePage.clickWatchlistIcon();
		implicitBreaks(50);

		if ((homePage.getNoWatchlistItemLabel().contains("My Wishlist"))) {
			homePage.clickRemoveItemfromWatchlistBtn();
			implicitBreaks(50);
		}else {System.out.println("watchlist label = " + homePage.getNoWatchlistItemLabel());}
		
		Assert.assertEquals(homePage.getNoWatchlistItemLabel(), "YOUR WISHLIST IS EMPTY",
				"Item still present under wish list");
	}

	@AfterMethod
	public void closeDriver() {
		homePage.logoutUser();
		driver.quit();
	}
}
