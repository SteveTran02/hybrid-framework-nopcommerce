package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01_Month_Days() {
		System.out.println("Input one number = ");
		int month = scanner.nextInt();

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Month " + month + " have 31 days");
			break;
		case 2:
			System.out.println("Month " + month + " have 28 or 29 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Month " + month + " have 30 days");
			break;
		default:
			System.out.println("Vui long nhap lai trong khoang 1-12");
			break;
		}

	}

	// @Test
	public void TC_02_Month_Name() {
		System.out.print("Input Month number = ");
		int month = scanner.nextInt();

		switch (month) {
		case 1:
			System.out.println("January");
			break;
		case 2:
			System.out.println("February");
			break;
		case 3:
			System.out.println("March");
			break;
		case 4:
			System.out.println("April");
			break;
		case 5:
			System.out.println("May");
			break;
		case 6:
			System.out.println("June");
			break;
		case 7:
			System.out.println("July");
			break;
		case 8:
			System.out.println("August");
			break;
		case 9:
			System.out.println("September");
			break;
		case 10:
			System.out.println("October");
			break;
		case 11:
			System.out.println("November");
			break;
		case 12:
			System.out.println("December");
			break;
		default:
			System.out.println("Vui long nhap lai trong khoang 1-12");
			break;
		}

	}

	// @ Parameters("browser")
	// @Test
	public void TC_03_If_Else_If_Else(String browserName) {
		driver = getBrowserDriver(browserName);

		System.out.println(browserName);
		System.out.println(driver.toString());

		driver.quit();
	}

	@Test
	public void TC_04_Operator() {

		System.out.print("Input A = ");
		int firstNumber = scanner.nextInt();
		System.out.print("Input B = ");
		int secondNumber = scanner.nextInt();
		System.out.print("Operator is ");
		String operator = scanner.next();

		switch (operator) {
		case "+":
			System.out.println("A + B = " + (firstNumber + secondNumber));
			break;
		case "-":
			System.out.println("A - B = " + (firstNumber - secondNumber));
			break;
		case "*":
			System.out.println("A * B = " + (firstNumber * secondNumber));
			break;
		case "/":
			System.out.println("A / B = " + (firstNumber / secondNumber));
			break;
		case "%":
			System.out.println("A % B = " + (firstNumber % secondNumber));
			break;
		}

	}

	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Please input correct the browser name!");
			break;
		}
		return driver;
	}

}
