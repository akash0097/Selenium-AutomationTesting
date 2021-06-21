package com.myntra.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	//Object Repository

	@FindBy(xpath = "//input[@class = 'form-control mobileNumberInput']")
	WebElement mobiNoField;
	
	@FindBy(xpath = " //div[@id=\"reactPageContent\"]/div/div/div[2]/div[2]/div[3]")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@id=\"reactPageContent\"]/div/div[3]/span")
	WebElement passwordLink;
	
	@FindBy(xpath = "//input[@id='mobileNumberPass']")
	WebElement populatedMobiNoField;
	
	@FindBy(xpath = "//input[@class = 'form-control has-feedback']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@class='btn primary  lg block submitButton']")
	WebElement loginBtn;
	
	//Initialize Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void setMobiNofield(String mobiNo) {
		mobiNoField.sendKeys(mobiNo);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	public void clickPasswordLink() {
		passwordLink.click();
	}
	
	public void setPopulatedMobiNoField(String mobiNo) {
		populatedMobiNoField.sendKeys(mobiNo);
	}
	
	public void clearPopulatedMobiNoField() {
		populatedMobiNoField.clear();
	}
	
	public void setPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	
	public HomePage login(String mobiNo , String password) {
		//To create random mobile number
		long max = 1111111111;
		long min = 2000000000;
		
		long randomNumber = (long) (Math.random()*(max-min+1)+min);
		String randomMobi = String.valueOf(randomNumber);
		implicitBreaks(30);
		mobiNoField.sendKeys(randomMobi);
		continueBtn.click();
		implicitBreaks(30);
		
		passwordLink.click();
		implicitBreaks(30);
		
		populatedMobiNoField.clear();
		populatedMobiNoField.sendKeys(mobiNo);
		passwordField.sendKeys(password);
		loginBtn.click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return new HomePage();
	}
}
