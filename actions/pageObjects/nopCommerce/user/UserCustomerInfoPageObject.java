package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopComerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {

	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isToCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_ATTRIBUTE_VALUE);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRSTNAME_ATTRIBUTE_VALUE, "value");
	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LASTNAME_ATTRIBUTE_VALUE);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LASTNAME_ATTRIBUTE_VALUE, "value");
	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_ATTRIBUTE_VALUE);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_ATTRIBUTE_VALUE, "value");
	}

}
