package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	protected static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
	}

	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;

	/* Web Browser */
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindowsByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (!actualTitle.equals(tabTitle)) {
				break;
			}
		}
	}

	protected void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.quit();
			}
			driver.switchTo().window(parentID);
		}
	}

	protected Set<Cookie> getBrowserCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}

	protected void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	protected void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	/* Web Element */
	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, WebElement element, String itemValue) {
		new Select(element).selectByVisibleText(itemValue);
	}

	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, WebElement element) {
		return new Select(element).getFirstSelectedOption().getText();
	}

	protected boolean isDefaultDropdownMultiple(WebDriver driver, WebElement element) {
		return new Select(element).isMultiple();
	}

	protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	protected String getElementCssValue(WebDriver driver, WebElement element, String cssPropertyName) {
		return element.getCssValue(cssPropertyName);
	}

	protected String convertRGBAToHexaColor(WebDriver driver, WebElement element) {
		String backgroundColorRGBA = getElementCssValue(driver, element, "background-color");
		return Color.fromString(backgroundColorRGBA).asHex();
	}

	protected int getListElementSize(WebDriver driver, List<WebElement> elements) {
		return elements.size();
	}

	/**
	 * Apply for checkbox and radio button
	 * 
	 * @param driver
	 * @param locatorType
	 */
	protected void checkToDefaultCheckboxOrRadio(WebDriver driver, WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	/**
	 * Only apply for checkbox
	 * 
	 * @param driver
	 * @param locatorType
	 */
	protected void uncheckToDefaultCheckbox(WebDriver driver, WebElement element) {
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	/* Frame and Iframe */
	protected void switchToIframe(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/* Actions - Interaction */
	protected void hoverMouseToElement(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	protected void doubleClickToElement(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	protected void rightClickToElement(WebDriver driver, WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}

	protected void dragAndDropElement(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		new Actions(driver).dragAndDrop(sourceElement, targetElement).perform();
	}

	protected void sendKeyBoardToElement(WebDriver driver, WebElement element, Keys key) {
		new Actions(driver).sendKeys(element, key).perform();
	}

	/* Web Driver Wait */
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.invisibilityOf(element));
	}

	protected void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.elementToBeClickable(element));
	}

}
