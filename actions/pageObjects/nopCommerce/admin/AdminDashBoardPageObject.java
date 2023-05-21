package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopComerce.admin.AdminDashBoardPageUI;

public class AdminDashBoardPageObject extends BasePage {

	WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardHeaderDisplayed() {
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASH_BOARD_HEADER);
	}

}
