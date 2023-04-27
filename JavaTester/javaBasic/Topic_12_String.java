package javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_12_String {

	public static void main(String[] args) {
		String schoolName1 = "Automation Testing Framework";
		String schoolName2 = "AUTOMATION TESTING FRAMEWORK";
		String schoolAddress = "Taiwan";

		System.out.println("Độ dài = " + schoolName1.length());

		System.out.println("Lấy ra một ký tự = " + schoolName1.charAt(4));

		System.out.println("Nối 2 chuỗi = " + schoolName1.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName1 + schoolAddress);

		// tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName1.equals(schoolAddress));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName1.equals("Automation Testing Framework"));

		// Multiple browser
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName1.equalsIgnoreCase(schoolName2));

		// startsWith/ endsWith/ contains
		System.out.println("Có bắt đầu bằng kí tự/chuỗi kí tự = " + schoolName1.startsWith("Automation"));
		System.out.println("Có bắt đầu bằng kí tự/chuỗi kí tự = " + schoolName1.startsWith("A"));
		System.out.println("Có bắt đầu bằng kí tự/chuỗi kí tự = " + schoolName1.startsWith("Testing"));

		System.out.println("Có chứa kí tự/chuỗi kí tự = " + schoolName1.contains("Automation"));
		System.out.println("Có chứa kí tự/chuỗi kí tự = " + schoolName1.contains("Testing"));
		System.out.println("Có chứa kí tự/chuỗi kí tự = " + schoolName1.contains("Advance"));

		System.out.println("Có kết thúc bằng kí tự/chuỗi kí tự = " + schoolName1.endsWith("Framework"));
		System.out.println("Có kết thúc bằng kí tự/chuỗi kí tự = " + schoolName1.endsWith("k"));
		System.out.println("Có kết thúc bằng kí tự/chuỗi kí tự = " + schoolName1.endsWith("Automation"));

		System.out.println("Vị trí index kí tự/chuỗi kí tự trong String = " + schoolName1.indexOf("m"));
		System.out.println("Vị trí index kí tự/chuỗi kí tự trong String = " + schoolName1.indexOf("Automation"));

		// Tách chuỗi
		String results = "Viewing 48 of 134 results";
		String result[] = results.split(" ");
		System.out.println(result[1]);

		// Substring
		String text = results.substring(8, 10);
		System.out.println(text);

		// Replace
		String productPrice = "$100";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);

		// Covert String to Float
		// Sắp xếp nó: Sort Data (ASC / DESC)
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);
		// Covert String to Float
		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice);
		// Convert_String_To_Int
		int productPriceI = Integer.parseInt(result[1]);
		System.out.println(productPriceI);
		productPriceI = Integer.parseInt(result[3]);
		System.out.println(productPriceI);

	}

	// @Test
	public void TC_Lower_Case_And_Upper_Case() {
		// Lower case/ Upper case
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		String osName = System.getProperty("os.name");
		System.out.println(osName);
		// Windows 11 => windows 11
		// Handle multiple Operating System: Windows/Mac OS (Actions - Keys - Ctrl or Command)
		if (osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;
		} else {
			Keys key = Keys.COMMAND;
		}

		// Multiple browser
		// firefox => FIREFOX (Enum)

		String driverInstanceName = driver.toString();
		System.out.println(driverInstanceName);
		// FirefoxDriver: firefox on WINDOWS (0421d44b-4da6-4ee9-a968-97710e8b6d89)
		// Close browser/ driver
		if (driverInstanceName.contains("internetexplorer")) {
			// sleep cứng thêm 5s sau mỗi sự kiện chuyển page
		}
	}

	// @Test
	public void TC_Trim() {
		// Khoảng trắng/ xuống dòng/ tab
		String helloWorld = "  \n    \t      Hello World!       ";
		System.out.println(helloWorld);
		System.out.println(helloWorld.trim());
	}

	// @Test
	public void TC_isEmpty_isBlank() {
		String helloWorld = " ";
		System.out.println("Empty = " + helloWorld.isEmpty());
		System.out.println("Brank = " + helloWorld.isBlank());
	}

	@Test
	public void TC_Format() {
		// Dynamic locator
		// Đại diện cho 1 chuỗi: %s
		// %b %t %d
		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
		System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));
	}

}
