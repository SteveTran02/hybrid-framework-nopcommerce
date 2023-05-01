package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_DRY {
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

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register"))).click();

		// Action
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#register-button"))).click();

		// Verify
		String firstNameErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#FirstName-error"))).getText();
		Assert.assertEquals(firstNameErrorMessage, "First name is required.");

		String lastNameErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#LastName-error"))).getText();
		Assert.assertEquals(lastNameErrorMessage, "Last name is required.");

		String emailErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#Email-error"))).getText();
		Assert.assertEquals(emailErrorMessage, "Email is required.");

		String passwordErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#Password-error"))).getText();
		Assert.assertEquals(passwordErrorMessage, "Password is required.");

		String confirmPasswordErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#ConfirmPassword-error"))).getText();
		Assert.assertEquals(confirmPasswordErrorMessage, "Password is required.");

	}

	@Test
	public void TC_02_Register__Invalid_Email() {

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register"))).click();

		// Action
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#FirstName"))).sendKeys("Pure");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#LastName"))).sendKeys("Insight");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email"))).sendKeys("123@123");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Password"))).sendKeys("123456789");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ConfirmPassword"))).sendKeys("123456789");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#register-button"))).click();

		// Verify
		String emailErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-error.validation-summary-errors li"))).getText();
		Assert.assertEquals(emailErrorMessage, "Wrong email");

	}

	@Test
	public void TC_03_Register__Success() {

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register"))).click();

		// Action
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#FirstName"))).sendKeys("Pure");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#LastName"))).sendKeys("Insight");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email"))).sendKeys(emailAddress);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Password"))).sendKeys("123456789");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ConfirmPassword"))).sendKeys("123456789");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#register-button"))).click();

		// Verify
		String successErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result"))).getText();
		Assert.assertEquals(successErrorMessage, "Your registration completed");

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register"))).click();

		// Action
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#FirstName"))).sendKeys("Pure");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#LastName"))).sendKeys("Insight");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email"))).sendKeys(emailAddress);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Password"))).sendKeys("123456789");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ConfirmPassword"))).sendKeys("123456789");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#register-button"))).click();

		// Verify
		String existingEmailMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-error.validation-summary-errors"))).getText();
		Assert.assertEquals(existingEmailMessage, "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register"))).click();

		// Action
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#FirstName"))).sendKeys("Pure");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#LastName"))).sendKeys("Insight");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email"))).sendKeys(emailAddress);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Password"))).sendKeys("123");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ConfirmPassword"))).sendKeys("123456789");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#register-button"))).click();

		// Verify
		String passwordErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#Password-error"))).getText();
		Assert.assertEquals(passwordErrorMessage, "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register"))).click();

		// Action
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#FirstName"))).sendKeys("Pure");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#LastName"))).sendKeys("Insight");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email"))).sendKeys(emailAddress);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Password"))).sendKeys("123456789");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ConfirmPassword"))).sendKeys("123456");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#register-button"))).click();

		// Verify
		String confirmPasswordErrorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#ConfirmPassword-error"))).getText();
		Assert.assertEquals(confirmPasswordErrorMessage, "The password and confirmation password do not match.");

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
