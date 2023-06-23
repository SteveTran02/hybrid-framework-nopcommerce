package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_3_Inheritance extends BasePage {
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	String emailAddress;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		emailAddress = "pureinsight" + getRandomNumber() + "@gmail.com";
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Action
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify
		waitForElementVisible(driver, "//span[@id='FirstName-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");

		waitForElementVisible(driver, "//span[@id='LastName-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");

		waitForElementVisible(driver, "//span[@id='Email-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");

		waitForElementVisible(driver, "//span[@id='Password-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");

		waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Register__Invalid_Email() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Action
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");

		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", "Insight");

		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", "pure123");

		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "pureinsight123");

		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pureinsight123");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify
		waitForElementVisible(driver, "//span[@id='Email-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register__Success() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Action
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");

		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", "Insight");

		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);

		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "pureinsight123");

		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pureinsight123");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify
		waitForElementVisible(driver, "//div[@class='result']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

	}

	@Test
	public void TC_04_Register_Existing_Email() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Action
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");

		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", "Insight");

		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);

		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "pureinsight123");

		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pureinsight123");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify
		waitForElementVisible(driver, "//div[contains(@class,'message-error')]");
		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]"), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Action
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");

		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", "Insight");

		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);

		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "pure");

		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pure");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify
		waitForElementVisible(driver, "//span[@id='Password-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Action
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");

		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", "Insight");

		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);

		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "pureinsight");

		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pure1234");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify
		waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
