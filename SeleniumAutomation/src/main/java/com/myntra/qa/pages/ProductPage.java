package com.myntra.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.qa.base.TestBase;

public class ProductPage extends TestBase{
	
	//Page Repository
	
	@FindBy(xpath = "//h1[@class='pdp-title']")
	WebElement productTitle;
	
	@FindBy(xpath = "//h1[@class='pdp-name']")
	WebElement productDescription;
	
	@FindBy(xpath = "//div[@id='mountRoot']/div/div/div/main/div[2]/div[2]/div[1]/p[1]/span[1]/strong")
	WebElement productPrice;
	
	@FindBy(xpath = "//div[@id='detailedReviewsContainer']/div[1]/div[1]/div[2]")
	WebElement firstProductReview;

	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public String getProductTitle() {
		return productTitle.getText();
	}
	
	public String getproductDescription() {
		return productDescription.getText();
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public ArrayList<String> listOfTopThreeProductReviews(){
		ArrayList<String> listOfTopThreeReviews = new ArrayList<String>();
		String xpathofReviews= "//div[@id='detailedReviewsContainer']/div[1]/div[1]/div[2]";
		for (int i = 1; i <= 3; i++) {
			xpathofReviews = "//div[@id='detailedReviewsContainer']/div["+ i +"]/div[1]/div[2]";
			
			if(driver.findElement(By.xpath(xpathofReviews)).isDisplayed()) {
				listOfTopThreeReviews.add(driver.findElement(By.xpath(xpathofReviews)).getText());
			}
		}
		return listOfTopThreeReviews;
	}
}
