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
		Reporter.log("Before Method - Open setUp");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
		Reporter.log("Before Method - Close setUp");
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		Reporter.log("Test - Open verifyHomePageTitleTest");
		implicitBreaks(50);
		String homePageTitle = homePage.getHomePageTitle();
		System.out.println("Actual title = " + homePageTitle);
		Assert.assertEquals(homePageTitle, "Myntra", "Home Page title is not displayed as expected");
		Reporter.log("Test - Close verifyHomePageTitleTest");
	}

	@Test(priority = 2)
	public void searchItemUsingSearchBoxTest() {
		Reporter.log("Test - Open searchItemUsingSearchBoxTest");
		String searchByText = "Kurtas";
		implicitBreaks(100);

		System.out.println("Page loadeded");

		homePage.clicksearchTextfield();
		implicitBreaks(10);

		homePage.setSearchField(searchByText);
		implicitBreaks(10);

		homePage.clickSearchFieldBtn();
		implicitBreaks(50);

		Assert.assertEquals(homePage.getSearchedItemLabel(), "Kurtas Online", "Label for the searched item is not matching");
		Reporter.log("Test - Close searchItemUsingSearchBoxTest");
	}

	@Test(priority = 3)
	public void fliterItemsTest() {
		Reporter.log("Test - Open fliterItemsTest");
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

		Assert.assertEquals(homePage.getSearchedItemLabel(), "Jackets For Men", "Label for the filtered item is not matching");
		Reporter.log("Test - Close fliterItemsTest");
	}

	@Test(priority = 4)
	public void addItemsToWatchlistTest() {
		Reporter.log("Test - Open addItemsToWatchlistTest");
		implicitBreaks(100);
		homePage.clickJacketsUnderMensSectionFromMenu();
		implicitBreaks(50);

		homePage.addItemToWatchList();
		implicitBreaks(30);

		System.out.println("After wish listing = " + homePage.getWatchlistedLabel());
		Assert.assertEquals(homePage.getWatchlistedLabel(), "WISHLISTED", "Selected item is not wish listed");
		Reporter.log("Test - Close addItemsToWatchlistTest");
	}

	@Test(priority = 5)
	public void removeItemFromWatchlistTest() {
		Reporter.log("Test - Open removeItemFromWatchlistTest");
		implicitBreaks(100);
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
	}

	// working with list
	@Test(priority = 6)
	public void getListItemsUnderMensEvenCol() {
		Reporter.log("Test - Open getListItemsUnderMensEvenCol");
		System.out.println("Displaying all the items under Mens section");
		List<WebElement> listOfitems = homePage.getListOfItemsUnderMens();
		
		System.out.println("***List Of "+ listOfitems.size() +" Items Under Mens Section ***");
		if (listOfitems != null) {
			for (WebElement webElement : listOfitems) {
				System.out.println("Mens items = " + webElement.getText());
			}
		}
		Reporter.log("Test - Close getListItemsUnderMensEvenCol");
	}

	@AfterMethod
	public void closeDriver() {
		Reporter.log("After Method - Open closedDriver");
		driver.quit();
		Reporter.log("After Method - Close closeDriver");
	}
}
