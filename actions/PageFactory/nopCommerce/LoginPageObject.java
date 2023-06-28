package PageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopComerce.user.UserLoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// 1. Define Page UI by WebElement
	@CacheLookup
	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@CacheLookup
	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@CacheLookup
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@CacheLookup
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@CacheLookup
	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessfullErrorMessage;

	@CacheLookup
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	// 2. Page Object
	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);
	}

	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, validPassword);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageUnsucessfull() {
		waitForElementVisible(driver, unsuccessfullErrorMessage);
		return getElementText(driver, unsuccessfullErrorMessage);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
