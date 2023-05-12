package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_NopEcommerce;
import pageObjects.nopEcommerce.HomePageObject;
import pageObjects.nopEcommerce.LoginPageObject;
import pageObjects.nopEcommerce.RegisterPageObject;

public class Level_06_Page_Generator_Manager_Part_1 extends BaseTest_NopEcommerce {
	private WebDriver driver;
	private String firstName, lastName, exsitingEmail, invalidEmail, notPoundEmail, validPassword, incorrectPassword, confirmPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = new HomePageObject(driver);

		firstName = "Pure";
		lastName = "Insight";
		exsitingEmail = "pureinsight" + getRandomNumber() + "@gmail.com";
		invalidEmail = "123456";
		notPoundEmail = "pureinsight" + getRandomNumber() + "@yahoo.com";
		validPassword = confirmPassword = "pureinsight";
		incorrectPassword = "123456";

		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-Condition - Step 02: input to required fields ");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(exsitingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message");
		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition - Step 04: Click to Continue button");
		registerPage.clickToContinueButton();

		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_01 - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_01 - Step 03: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_02 - Step 02: Input into required textbox");
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		System.out.println("Login_02 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_02 - Step 03: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Pound() {
		System.out.println("Login_03 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_03 - Step 02: Input into required textbox");
		loginPage.inputToEmailTextbox(notPoundEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		System.out.println("Login_03 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_03 - Step 03: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsucessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login_04 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_04 - Step 02: Input into required textbox");
		loginPage.inputToEmailTextbox(exsitingEmail);

		System.out.println("Login_04 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_04 - Step 03: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsucessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		System.out.println("Login_05 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_05 - Step 02: Input into required textbox");
		loginPage.inputToEmailTextbox(exsitingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);

		System.out.println("Login_05 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_05 - Step 03: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsucessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		System.out.println("Login_05 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_05 - Step 02: Input into required textbox");
		loginPage.inputToEmailTextbox(exsitingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		System.out.println("Login_05 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_05 - Step 03: Verify login successfully");
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isToMyAccountLink());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}