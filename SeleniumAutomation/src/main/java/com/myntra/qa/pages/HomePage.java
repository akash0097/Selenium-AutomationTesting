package com.myntra.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myntra.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//input[@class = 'desktop-searchBar']")
	WebElement searchTextField;

	@FindBy(xpath = "//a[@class = 'desktop-submit']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='desktop-infoEmail']")
	WebElement loggedInMobiNo;

	@FindBy(xpath = "//span[contains(text(),'Profile')]")
	WebElement profileIcon;
	
	@FindBy(xpath = "//header[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/a")
	WebElement menMenuSection;

	@FindBy(xpath = "//header[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/div/div/div/li[1]/ul/li[7]/a")
	WebElement mensJackets;

	@FindBy(xpath = "//div[@id='desktopSearchResults']/div[1]/section/div[1]/div[2]/ul/li[3]/label")
	WebElement sizeSelector;

	@FindBy(xpath = "//div[@id='desktopSearchResults']/div[1]/section/div[1]/div[2]/div/ul/li[9]/label")
	WebElement selectMSize;

	@FindBy(xpath = "//div[@id='mountRoot']/div/div[1]/main/div[3]/div[1]/section/div/div[3]/div[1]")
	WebElement brandSearchBtn;

	@FindBy(xpath = "//div[@id='mountRoot']/div/div[1]/main/div[3]/div[1]/section/div/div[3]/div[1]/input")
	WebElement brandSearchField;

	@FindBy(xpath = "//div[@id='mountRoot']/div/div[1]/main/div[3]/div[1]/section/div/div[3]/ul/li/label")
	WebElement brandSearchedChckBox;

	@FindBy(xpath = "//h1[@class='title-title']")
	WebElement searchedItemLabel;

	@FindBy(xpath = "//div[@id='desktopSearchResults']/div[2]/section/ul/li[1]/a")
	WebElement firstItem;

	@FindBy(xpath = "//div[@id='desktopSearchResults']/div[2]/section/ul/li[1]/div[4]/span")
	WebElement watchlistBtn;

	@FindBy(xpath = "//div[@id='desktopSearchResults']/div[2]/section/ul/li[1]/div[4]/span[1]")
	WebElement watchlistedLabel;

	@FindBy(xpath = "//header[@id='desktop-header-cnt']/div[2]/div[2]/a[1]/span[2]")
	WebElement watchlistIcon;

	@FindBy(xpath = "//div[@id='item0']/div[1]/div")
	WebElement removeWatchlistedItemBtn;

	@FindBy(xpath = "//div[@id='mountRoot']/div/div/div/div/div/div[1]")
	WebElement noWatchlistItemLabel;

	@FindBy(xpath = "//header[@id='desktop-header-cnt']/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/div")
	WebElement logoutBtn;

	//working with list
	@FindBy(xpath = "//div[@data-group = 'men']/li/ul/li/a")
	List<WebElement> listOfItermsUnderMens;
	
	// Initializing Page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Methods OR Actions

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getPageTitleAfterSearch() {
		return driver.getTitle();
	}

	public void addItemToWatchList() {
		firstItem = expilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='desktopSearchResults']/div[2]/section/ul/li[1]/a")));
		Actions action = new Actions(driver);
		action.moveToElement(firstItem).pause(10).moveToElement(watchlistBtn).click().build().perform();
	}

	public String getWatchlistedLabel() {
		return watchlistedLabel.getText();
	}

	public void clickJacketsUnderMensSectionFromMenu() {
		menMenuSection = expilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/a")));	
		Actions action = new Actions(driver);
		action.moveToElement(menMenuSection).pause(20).moveToElement(mensJackets).click().build().perform();
	}

	public void clickFilterSizeSelector() {
		sizeSelector.click();
	}

	public void clickFilterSizeM() {
		selectMSize.click();
	}

	public void clickBrandSearchBtn() {
		brandSearchBtn.click();
	}

	public void setBrandSearchField(String brandName) {
		brandSearchField.sendKeys(brandName);
	}

	public void clickBrandSearchCheckBox() {
		brandSearchedChckBox.click();
	}

	public void clicksearchTextfield() {
		searchTextField = expilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'desktop-searchBar']")));
		searchTextField.click();
	}
	
	public void setSearchField(String searchText) {
		
		searchTextField.sendKeys(searchText);
	}

	public void clickSearchFieldBtn() {
		searchButton.click();
	}

	public String getSearchedItemLabel() {
		return searchedItemLabel.getText();
	}

	public void clickWatchlistIcon() {
		watchlistIcon.click();
	}

	public void clickRemoveItemfromWatchlistBtn() {
		
		removeWatchlistedItemBtn.click();
	}

	public String getNoWatchlistItemLabel() {
		return noWatchlistItemLabel.getText();
	}

	public void logoutUser() {
		profileIcon = expilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile')]")));
		Actions action = new Actions(driver);
		action.moveToElement(profileIcon).moveToElement(logoutBtn).click().build().perform();
	}
	
	public List<WebElement> getListOfItemsUnderMens() {
		Actions action = new Actions(driver);
		action.moveToElement(menMenuSection).build().perform();
		return listOfItermsUnderMens;
	}
	
}
