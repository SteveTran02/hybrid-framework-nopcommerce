package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	// @Test
	public void TC_01_If() {

		// Element luôn có trong DOM dù Popup có hiển thị không
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			
		}
		
		
		// Element không có trong DOM khi Popup không hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		// Check Element không hiển thị
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
			
		}
		
		// Uncheck to checkbox
		WebElement languagesCheckbox = driver.findElement(By.xpath(""));
		if (languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
		
		// Check to checkbox
		if (!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}		
	}
	
	// @Test
	public void TC_02_If_Else() {

		// Có tới 2 đk nếu true thì vào If, false thì vào else
		
		// Nếu driver start với browser như Chrome/ Firefox/ Edge/ Safari thì dùng hàm click thông thường (builtin) của Selenium Webdriver
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Nếu driver là IE thì dùng hàm JavascriptExecutor 		
//		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();	
//		
		System.out.println(driver.toString());

		if (driver.toString().contains("internet explorer")) {
			System.out.println("Click by JavascriptExecutor");
		} else {
			System.out.println("Click by Selenium Webdriver");
		}
		
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void TC_03_If_Else_If_Else(String browserName) {
		// Có nhiều điều kiện 
		// Best Practice: không nên if-else nhiều 
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		} else {  // Safari/ Opera/ Coccoc...
			throw new RuntimeException("Please input correct the browser name!");
		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}

	// @Test
	public void TC_04_If_Else_If_Else() {
		// Page Object
		// return loginPage
		
		String pageName = "Login";
		
		if (pageName.equals("Login")) {
			// Login login = new LoginPage();
			// return loginPage;
		} else if (pageName.equals("Register")) {
			// Register register = new RegisterPage();
			// return registerPage;
		} else if (pageName.equals("New Customer")) {
			// CustomerPage customerPage = new CustomerPage();
			// return customerPage;
		} else {
			// HomePage homePage = new HomePage();
			// return homePage;
		}
		
		
		// if-else
		int numberGuess = 9;
		String access = (numberGuess < 20) ? "Your guess is lower than the number I pick" : "Your guess is higher than the number I pick";
		
		if (numberGuess < 20) {
			access = "Your guess is lower than the number I pick";
		} else {
			access = "Your guess is higher than the number I pick";
		}
		System.out.println(access);
	}
	
}
