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

public class Level_09_Dynamic_Locator extends BaseTest {
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
	public void User_01_Register_Login() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(EmailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();

		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(EmailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isToMyAccountLink());

		customerInfoPage = homePage.openMyAccountPage(driver);
		Assert.assertTrue(customerInfoPage.isToCustomerInfoPageDisplayed());
	}

	@Test
	public void User_02_Switch_Page() {
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
	}

	@Test
	public void User_03_Dynamic_Page_01() {
		// My product review -> Reward points
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
		// Reward points -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
		// Address -> Reward points
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");
		// Reward points -> My product review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
	}

	@Test
	public void User_03_Dynamic_Page_02() {
		// My product review -> Customer info
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		// Customer info -> Reward points
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		// Reward points -> Address
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowser();
	}

}