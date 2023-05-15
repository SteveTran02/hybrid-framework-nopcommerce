package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_LiveGuru;
import pageObjects.liveGuru.DashBoardPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_06_Page_Generator_Manager_Part_3 extends BaseTest_LiveGuru {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private DashBoardPageObject dashboardPage;
	private String firstName, lastName, emailAddress, password, confirmPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		getBrowserDriver(browserName);
		PageGeneratorManager.getHomePage(driver);

		firstName = "pure";
		lastName = "insight";
		emailAddress = "pureinsight" + getRandomNumber() + "@gmail.com";
		password = confirmPassword = "123456";

	}

	@Test
	public void TC_01_Register_Success_To_System() {

		System.out.println("TC_01: Step 1: Click on Account link");
		loginPage = homePage.clickToMyAccountLink();

		System.out.println("TC_01: Step 2: Choose Create an Account button");
		registerPage = loginPage.clickToCreateAnAccountButton();

		System.out.println("TC_01: Step 3: Input all valid data to form");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		System.out.println("TC_01: Step 4: Click Register button");
		dashboardPage = registerPage.clickToRegisterButton();

		System.out.println("TC_01: Step 5: Verify register new account success message");
		Assert.assertEquals(dashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

		System.out.println("TC_01: Step 6: Click Account information link");
		dashboardPage.clickToAccountInformation();

		System.out.println("TC_01: Step 7: Verify data in 3 fields First name, Last name and Email Address");
		Assert.assertEquals(dashboardPage.getAttributeValueFirstnameTextbox(), firstName);
		Assert.assertEquals(dashboardPage.getAttributeValueLastnameTextbox(), lastName);
		Assert.assertEquals(dashboardPage.getAttributeValueEmailAddressTextbox(), emailAddress);

		System.out.println("TC_01: Step 8: Click Account menu");
		dashboardPage.clickToAccountMenu();

		System.out.println("TC_01: Step 9: Click Logout link");
		homePage = dashboardPage.clickToLogoutLink();

		System.out.println("TC_01: Step 10: Click on Account link");
		loginPage = homePage.clickToMyAccountLink();

		System.out.println("TC_01: Step 11: Input valid data into Email Address and Password textbox");
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		dashboardPage = loginPage.clickToLoginButton();

		System.out.println("TC_01: Step 12: Verify login success message");
		Assert.assertEquals(dashboardPage.getLoginSuccessMessage(), "Hello, " + firstName + " " + lastName + "!");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
