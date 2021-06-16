package com.myntra.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties props;

	public TestBase() {
		props = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"C:/Users/THALA/eclipse-workspace/SeleniumAutomation/src/main/java/com/myntra/qa/config/config.properties");
			props.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		// To get the name of browser
		String browserName = props.getProperty("browser");
		System.out.println("Browser User = " + browserName + "URL = " + props.getProperty("url"));

		System.setProperty("webdriver.chrome.driver", "D:/Selenium Automation/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(props.getProperty("url"));

	}

}
