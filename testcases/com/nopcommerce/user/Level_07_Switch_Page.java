package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest_NopCommerce;
import pageObjects.nopCommerce.AddressPageObject;
import pageObjects.nopCommerce.CustomerInfoPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyProductReviewPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.RewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest_NopCommerce {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Pure";
		lastName = "Insight";
		EmailAddress = "pureinsight" + getRandomNumber() + "@gmail.com";
		password = confirmPassword = "pureinsight";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(EmailAddress);
		System.out.println(EmailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(EmailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isToMyAccountLink());
	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isToCustomerInfoPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// Knowledge của page object
		// Khi page A chuyển sang page B thì phải viết 1 hàm
		// ( action, open, click... : link/button/image/...) để mở page B lên

		// Customer info -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		// Address -> My product review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		// My product review -> Reward points
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward points -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		// Address -> Reward points
		rewardPointPage = addressPage.openRewardPointPage(driver);
		// Reward points -> My product review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		// My product review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);
	}

	@Test
	public void User_05_Switch_Role() {
		// User role -> Admin role

		// Admin role -> User role

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, EmailAddress, password, confirmPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressPageObject addressPage;
	private RewardPointPageObject rewardPointPage;
	private MyProductReviewPageObject myProductReviewPage;
}