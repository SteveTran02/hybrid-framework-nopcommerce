package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseOOP {
	public long shortTimeOut = 10;
	protected long longTimeOut = 30;
	private WebDriver driver;

	public BaseOOP() {
		System.out.println("Contructor of  parent class");
	}

	public BaseOOP(String browserName) {
		System.out.println("Contructor of  parent class " + browserName);
	}

	public BaseOOP(int browserVersion) {
		System.out.println("Contructor of  parent class " + browserVersion);
	}

	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
}
