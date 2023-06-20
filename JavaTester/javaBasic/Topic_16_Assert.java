package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(commons.MethodListener.class)
public class Topic_16_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.futurelearn.com/");
	}

	@Test
	public void TC_01_Url() {
		System.out.println("Assert 01");
		verifyEquals(driver.getCurrentUrl(), "https://www.futurelearn.com/");

		System.out.println("Assert 02");
		verifyTrue(driver.findElement(By.xpath("//span[@class='index-module_content__25_HO' and text()='Register']")).isDisplayed());

		System.out.println("Assert 03");
		verifyFalse(driver.findElement(By.xpath("//span[@class='index-module_content__25_HO' and text()='Register']")).isDisplayed());

		System.out.println("Assert 04");
		verifyTrue(driver.findElement(By.xpath("//span[@class='index-module_content__25_HO' and text()='Register']")).isDisplayed());

		System.out.println("Assert 05");
		verifyTrue(driver.findElement(By.xpath("//span[@class='index-module_content__25_HO' and text()='Register']")).isDisplayed());

		System.out.println("Assert 06");
		verifyFalse(driver.findElement(By.xpath("//span[@class='index-module_content__25_HO' and text()='Register']")).isDisplayed());

		System.out.println("Assert 07");
		verifyTrue(driver.findElement(By.xpath("//span[@class='index-module_content__25_HO' and text()='Register']")).isDisplayed());

		System.out.println("Assert 08");
		verifyTrue(driver.findElement(By.xpath("//span[@class='index-module_content__25_HO' and text()='Register']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}