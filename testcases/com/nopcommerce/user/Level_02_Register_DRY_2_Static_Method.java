// package com.nopcommerce.user;
//
// import java.util.Random;
// import java.util.concurrent.TimeUnit;
//
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;
//
// import commons.BasePage;
//
// public class Level_02_Register_DRY_2_Static_Method {
// WebDriver driver;
// BasePage basepage;
//
// String projectPath = System.getProperty("user.dir");
// String osName = System.getProperty("os.name");
// WebDriverWait explicitWait;
// String emailAddress;
//
// @BeforeClass
// public void beforeClass() {
// if (osName.contains("Windows")) {
// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
// } else {
// System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
// }
//
// driver = new FirefoxDriver();
// basepage = BasePage.getBasePageObject();
//
// explicitWait = new WebDriverWait(driver, 30);
// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
// driver.manage().window().maximize();
//
// emailAddress = "pureinsight" + getRandomNumber() + "@gmail.com";
// driver.get("https://demo.nopcommerce.com/");
// }
//
// @Test
// public void TC_01_Register_Empty_Data() {
//
// basepage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basepage.clickToElement(driver, "//a[@class='ico-register']");
//
// // Action
// basepage.waitForElementClickable(driver, "//button[@id='register-button']");
// basepage.clickToElement(driver, "//button[@id='register-button']");
//
// // Verify
// basepage.waitForElementVisible(driver, "//span[@id='FirstName-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//
// basepage.waitForElementVisible(driver, "//span[@id='LastName-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//
// basepage.waitForElementVisible(driver, "//span[@id='Email-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//
// basepage.waitForElementVisible(driver, "//span[@id='Password-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//
// basepage.waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//
// }
//
// @Test
// public void TC_02_Register__Invalid_Email() {
//
// basepage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basepage.clickToElement(driver, "//a[@class='ico-register']");
//
// // Action
// basepage.waitForElementVisible(driver, "//input[@id='FirstName']");
// basepage.sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");
//
// basepage.waitForElementVisible(driver, "//input[@id='LastName']");
// basepage.sendkeyToElement(driver, "//input[@id='LastName']", "Insight");
//
// basepage.waitForElementVisible(driver, "//input[@id='Email']");
// basepage.sendkeyToElement(driver, "//input[@id='Email']", "pure123");
//
// basepage.waitForElementVisible(driver, "//input[@id='Password']");
// basepage.sendkeyToElement(driver, "//input[@id='Password']", "pureinsight123");
//
// basepage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
// basepage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pureinsight123");
//
// basepage.waitForElementClickable(driver, "//button[@id='register-button']");
// basepage.clickToElement(driver, "//button[@id='register-button']");
//
// // Verify
// basepage.waitForElementVisible(driver, "//span[@id='Email-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
// }
//
// @Test
// public void TC_03_Register__Success() {
//
// basepage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basepage.clickToElement(driver, "//a[@class='ico-register']");
//
// // Action
// basepage.waitForElementVisible(driver, "//input[@id='FirstName']");
// basepage.sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");
//
// basepage.waitForElementVisible(driver, "//input[@id='LastName']");
// basepage.sendkeyToElement(driver, "//input[@id='LastName']", "Insight");
//
// basepage.waitForElementVisible(driver, "//input[@id='Email']");
// basepage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
// basepage.waitForElementVisible(driver, "//input[@id='Password']");
// basepage.sendkeyToElement(driver, "//input[@id='Password']", "pureinsight123");
//
// basepage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
// basepage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pureinsight123");
//
// basepage.waitForElementClickable(driver, "//button[@id='register-button']");
// basepage.clickToElement(driver, "//button[@id='register-button']");
//
// // Verify
// basepage.waitForElementVisible(driver, "//div[@class='result']");
// Assert.assertEquals(basepage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//
// }
//
// @Test
// public void TC_04_Register_Existing_Email() {
//
// basepage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basepage.clickToElement(driver, "//a[@class='ico-register']");
//
// // Action
// basepage.waitForElementVisible(driver, "//input[@id='FirstName']");
// basepage.sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");
//
// basepage.waitForElementVisible(driver, "//input[@id='LastName']");
// basepage.sendkeyToElement(driver, "//input[@id='LastName']", "Insight");
//
// basepage.waitForElementVisible(driver, "//input[@id='Email']");
// basepage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
// basepage.waitForElementVisible(driver, "//input[@id='Password']");
// basepage.sendkeyToElement(driver, "//input[@id='Password']", "pureinsight123");
//
// basepage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
// basepage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pureinsight123");
//
// basepage.waitForElementClickable(driver, "//button[@id='register-button']");
// basepage.clickToElement(driver, "//button[@id='register-button']");
//
// // Verify
// basepage.waitForElementVisible(driver, "//div[contains(@class,'message-error')]");
// Assert.assertEquals(basepage.getElementText(driver, "//div[contains(@class,'message-error')]"), "The specified email already exists");
//
// }
//
// @Test
// public void TC_05_Register_Password_Less_Than_6_Chars() {
//
// basepage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basepage.clickToElement(driver, "//a[@class='ico-register']");
//
// // Action
// basepage.waitForElementVisible(driver, "//input[@id='FirstName']");
// basepage.sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");
//
// basepage.waitForElementVisible(driver, "//input[@id='LastName']");
// basepage.sendkeyToElement(driver, "//input[@id='LastName']", "Insight");
//
// basepage.waitForElementVisible(driver, "//input[@id='Email']");
// basepage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
// basepage.waitForElementVisible(driver, "//input[@id='Password']");
// basepage.sendkeyToElement(driver, "//input[@id='Password']", "pure");
//
// basepage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
// basepage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pure");
//
// basepage.waitForElementClickable(driver, "//button[@id='register-button']");
// basepage.clickToElement(driver, "//button[@id='register-button']");
//
// // Verify
// basepage.waitForElementVisible(driver, "//span[@id='Password-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6
// characters");
//
// }
//
// @Test
// public void TC_06_Register_Invalid_Confirm_Password() {
//
// basepage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basepage.clickToElement(driver, "//a[@class='ico-register']");
//
// // Action
// basepage.waitForElementVisible(driver, "//input[@id='FirstName']");
// basepage.sendkeyToElement(driver, "//input[@id='FirstName']", "Pure");
//
// basepage.waitForElementVisible(driver, "//input[@id='LastName']");
// basepage.sendkeyToElement(driver, "//input[@id='LastName']", "Insight");
//
// basepage.waitForElementVisible(driver, "//input[@id='Email']");
// basepage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
// basepage.waitForElementVisible(driver, "//input[@id='Password']");
// basepage.sendkeyToElement(driver, "//input[@id='Password']", "pureinsight");
//
// basepage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
// basepage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "pure1234");
//
// basepage.waitForElementClickable(driver, "//button[@id='register-button']");
// basepage.clickToElement(driver, "//button[@id='register-button']");
//
// // Verify
// basepage.waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
// Assert.assertEquals(basepage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//
// }
//
// public int getRandomNumber() {
// Random random = new Random();
// return random.nextInt(9999);
// }
//
// @AfterClass(alwaysRun = true)
// public void afterClass() {
// driver.quit();
// }
//
// }
