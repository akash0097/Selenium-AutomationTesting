package com.myntra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory OR Object Repository
	@FindBy(xpath = "//input[@class = 'desktop-searchBar']")
	WebElement seachTextField;
	
	@FindBy(xpath = "//a[@class = 'desktop-submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//div[@id=\"mountPoint\"]/div/div[2]/div[1]/div[2]/div[1]")
	WebElement mensMenuLink;
	
	//Initializing Page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Methods OR Actions
	
	public String validateTitleOfPage() {
		return driver.getTitle();
	}
	
	public boolean isMensMenuLinkDisplayed() {
		return mensMenuLink.isDisplayed();	
	}
	
	public void searchItems(String searchText) {
		seachTextField.sendKeys(searchText);
		searchButton.click();
	}
}
