package PageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// 1. Define Page UI by WebElement
	@CacheLookup
	@FindBy(how = How.ID, using = "FirstName")
	private WebElement firstNameTextbox;

	@FindBy(how = How.ID, using = "LastName")
	private WebElement lastNameTextbox;

	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox;

	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextbox;

	@FindBy(how = How.ID, using = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;

	@FindBy(how = How.ID, using = "register-button")
	private WebElement registerButton;

	@FindBy(how = How.ID, using = "FirstName-error")
	private WebElement firstNameErrorMessage;

	@FindBy(how = How.ID, using = "LastName-error")
	private WebElement lastNameErrorMessage;

	@FindBy(how = How.ID, using = "Email-error")
	private WebElement emailErrorMessage;

	@FindBy(how = How.ID, using = "Password-error")
	private WebElement passwordErrorMessage;

	@FindBy(how = How.ID, using = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(how = How.CLASS_NAME, using = "result")
	private WebElement registerSuccessMessage;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement existingEmailErrorMessage;

	@FindBy(how = How.CLASS_NAME, using = "ico-register")
	private WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'register-continue-button')]")
	private WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//div[@class='header-logo']//img")
	private WebElement nopEcommerceImage;

	// 2. Page Object/ Actions
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void inputToEmailTextbox(String exsitingEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, exsitingEmail);
	}

	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, validPassword);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);
	}
}
