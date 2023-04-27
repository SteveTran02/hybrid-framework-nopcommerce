package eclipseTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Debug {
	WebDriver driver;
	WebDriverWait explicitWait;

	@Test
	public void TC_01() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");

		// driver ID
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.get("https://www.theepochtimes.com/");

		// Verify text
		String textSologan = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.tagline"))).getText();
		Assert.assertEquals(textSologan, "TRUTH AND TRADITION");

		// Verify image
		boolean imageStatus = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Shen Yun Special Coverage']"))).isDisplayed();
		Assert.assertTrue(imageStatus);

		driver.quit();
	}

}