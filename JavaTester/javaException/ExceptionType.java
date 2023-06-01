package javaException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionType {
	ChromeDriver driver;

	@Test
	public void TC_01() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@id='header-account']//a[text()='Log In']")).click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
