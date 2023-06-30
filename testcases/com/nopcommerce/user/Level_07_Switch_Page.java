package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, EmailAddress, password, confirmPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

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
		customerInfoPage = homePage.openMyAccountPage(driver);
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
		closeBrowser();
	}

}