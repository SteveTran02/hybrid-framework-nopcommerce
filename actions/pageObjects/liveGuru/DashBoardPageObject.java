package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.DashBoardPageUI;

public class DashBoardPageObject extends BasePage {

	WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, DashBoardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, DashBoardPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickToAccountInformation() {
		waitForElementClickable(driver, DashBoardPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, DashBoardPageUI.ACCOUNT_INFORMATION_LINK);
	}

	public String getAttributeValueFirstnameTextbox() {
		waitForElementVisible(driver, DashBoardPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, DashBoardPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getAttributeValueLastnameTextbox() {
		waitForElementVisible(driver, DashBoardPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, DashBoardPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getAttributeValueEmailAddressTextbox() {
		waitForElementVisible(driver, DashBoardPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getElementAttribute(driver, DashBoardPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
	}

	public void clickToAccountMenu() {
		waitForElementClickable(driver, DashBoardPageUI.ACCOUNT_MENU_LINK);
		clickToElement(driver, DashBoardPageUI.ACCOUNT_MENU_LINK);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, DashBoardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, DashBoardPageUI.LOGIN_SUCCESS_MESSAGE);
		return getElementText(driver, DashBoardPageUI.LOGIN_SUCCESS_MESSAGE);
	}

}
