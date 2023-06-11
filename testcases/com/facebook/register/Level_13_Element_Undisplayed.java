package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private String emailAdress;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		emailAdress = "pureinsight@gmail.com";
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
		// verify true - mong đợi confirm email displayed -> true
		loginPage.enterToEmailTextbox(emailAdress);
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// verify false - mong đợi confirm email undisplayed -> false
		loginPage.enterToEmailTextbox("");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);
		// Case 3: element not in DOM
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// driver.quit();
	}

}
