package PageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageFactory extends BasePageFactory {

	private WebDriver driver;

	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// 1. Define Page UI by WebElement
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='ico-account']")
	private WebElement myAccountLink;

	// 2. Define Page Object/ Actions
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isToMyAccountLink() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}
}
