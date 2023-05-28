package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP {
	// Instance variable
	private long shortTimeOut = 10;
	private long longTimeOut = 30;
	private WebDriver driver;

	public Topic_05_This_Super() {
		super();
		System.out.println("Contructor of  child class");
	}

	public void setImplicitWait() {
		// Local variable
		long longTimeOut = 50;
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(super.shortTimeOut, TimeUnit.SECONDS);
	}

	public void clickToElement() {
		// dùng hàm ở class con
		setImplicitWait();

		// dùng super -> gọi hàm ở class cha
		super.setImplicitWait();
	}

	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super();

		BaseOOP base = new BaseOOP();
	}

}
