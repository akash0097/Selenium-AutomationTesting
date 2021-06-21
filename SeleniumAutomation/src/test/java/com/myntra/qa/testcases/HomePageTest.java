package com.myntra.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
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
		System.out.println("**Open setUp HomePageTest**");
		Reporter.log("Before Method - Open setUp");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		Reporter.log("Before Method - Close setUp");
		System.out.println("**Close setUp HomePageTest**");
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		System.out.println("**Test - Open verifyHomePageTitleTest**");
		Reporter.log("Test - Open verifyHomePageTitleTest");
		implicitBreaks(50);
		String homePageTitle = homePage.getHomePageTitle();
		System.out.println("Actual title = " + homePageTitle);
		Assert.assertEquals(homePageTitle, "Myntra", "Home Page title is not displayed as expected");
		Reporter.log("Test - Close verifyHomePageTitleTest");
		System.out.println("**Test - Close verifyHomePageTitleTest**");
	}

	@Test(priority = 2)
	public void verifyLoggedInUserMobileNumber() {
		System.out.println("**Test - Open verifyLoggedInUserMobileNumber**");
		Reporter.log("Test - Open verifyLoggedInUserMobileNumber");
		String loggedInUserMobileNumber = homePage.getUserMobileNumber();
		implicitBreaks(30);
		System.out.println("Logged in user mobile number = " + loggedInUserMobileNumber);
		Assert.assertEquals(loggedInUserMobileNumber, "8286515987", "Logged in user is different");
		Reporter.log("test - Close verifyLoggedInUserMobileNumber");
		System.out.println("**Test - Close verifyLoggedInUserMobileNumber**");
	}

	@Test(priority = 3)
	public void searchItemUsingSearchBoxTest() {
		System.out.println("**Test - Open searchItemUsingSearchBoxTest**");
		Reporter.log("Test - Open searchItemUsingSearchBoxTest");
		String searchByText = "Kurtas";
		implicitBreaks(100);
		homePage.clicksearchTextfield();
		implicitBreaks(10);

		homePage.setSearchField(searchByText);
		implicitBreaks(10);

		homePage.clickSearchFieldBtn();
		implicitBreaks(50);

		Assert.assertEquals(homePage.getSearchedItemLabel(), "Kurtas Online",
				"Label for the searched item is not matching");
		Reporter.log("Test - Close searchItemUsingSearchBoxTest");
		System.out.println("**Test - Close searchItemUsingSearchBoxTest**");
	}

	@Test(priority = 4)
	public void fliterItemsTest() {
		System.out.println("**Test - Open fliterItemsTest**");
		Reporter.log("Test - Open fliterItemsTest");
		String searchBy = "Roadster";

		implicitBreaks(30);
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

		Assert.assertEquals(homePage.getSearchedItemLabel(), "Jackets For Men",
				"Label for the filtered item is not matching");
		Reporter.log("Test - Close fliterItemsTest");
		System.out.println("**Test - Close fliterItemsTest**");
	}

	@Test(priority = 5)
	public void addItemsToWatchlistTest() {
		System.out.println("**Test - Open addItemsToWatchlistTest**");
		Reporter.log("Test - Open addItemsToWatchlistTest");
		implicitBreaks(30);
		homePage.clickJacketsUnderMensSectionFromMenu();
		implicitBreaks(50);

		homePage.addItemToWatchList();
		implicitBreaks(30);

		System.out.println("After wish listing = " + homePage.getWatchlistedLabel());
		Assert.assertEquals(homePage.getWatchlistedLabel(), "WISHLISTED", "Selected item is not wish listed");
		Reporter.log("Test - Close addItemsToWatchlistTest");
		System.out.println("**Test - Close addItemsToWatchlistTest**");
	}

	@Test(priority = 6)
	public void removeItemFromWatchlistTest() {
		System.out.println("**Test - Open removeItemFromWatchlistTest**");
		Reporter.log("Test - Open removeItemFromWatchlistTest");
		implicitBreaks(30);
		homePage.clickWatchlistIcon();
		implicitBreaks(50);

		if ((homePage.getNoWatchlistItemLabel().contains("My Wishlist"))) {
			homePage.clickRemoveItemfromWatchlistBtn();
			implicitBreaks(50);
		} else {
			System.out.println("watchlist label = " + homePage.getNoWatchlistItemLabel());
		}

		Assert.assertEquals(homePage.getNoWatchlistItemLabel(), "YOUR WISHLIST IS EMPTY",
				"Items are still present under wish list");
		Reporter.log("Test - Close removeItemFromWatchlistTest");
		System.out.println("**Test - Close removeItemFromWatchlistTest**");
	}

	// working with list
	@Test(priority = 7)
	public void getListItemsUnderMensEvenCol() {
		System.out.println("**Test - Open getListItemsUnderMensEvenCol**");
		Reporter.log("Test - Open getListItemsUnderMensEvenCol");
		System.out.println("Displaying all the items under Mens section");
		List<WebElement> listOfitems = homePage.getListOfItemsUnderMens();

		System.out.println("***List Of " + listOfitems.size() + " Items Under Mens Section ***");
		if (listOfitems != null) {
			for (WebElement webElement : listOfitems) {
				System.out.println("Mens items = " + webElement.getText());
			}
		}
		Reporter.log("Test - Close getListItemsUnderMensEvenCol");
		System.out.println("**Test - Close getListItemsUnderMensEvenCol**");
	}

	@AfterMethod
	public void closeDriver() {
		System.out.println("**Open CloseDriver HomePageTest**");
		Reporter.log("After Method - Open closedDriver");
		driver.quit();
		Reporter.log("After Method - Close closeDriver");
		System.out.println("**Close CloseDriver HomePageTest**");
	}
}
