package PageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopComerce.user.UserRegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='LastName']")
	private WebElement lastNameTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;

	@FindBy(how = How.XPATH, using = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(how = How.XPATH, using = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(how = How.XPATH, using = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(how = How.XPATH, using = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement existingEmailErrorMessage;

	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'register-continue-button')]")
	private WebElement continueButton;

	// Page Object/ Actions
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);
		sendkeyToElement(driver, lastNameTextBox, lastName);
	}

	public void inputToEmailTextbox(String invalidEmailAddress) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, invalidEmailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, confirmPassword);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);
	}

}
