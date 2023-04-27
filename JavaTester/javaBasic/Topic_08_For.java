package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@Test
	public void TC_01_For_Iterator() {
		
		// Array
		String[] cityName = {"London", "Singapore", "Taipei", "HaNoi"};
		
		// Array/ List/ Set/ Queue (index)
		
		// For kết hợp với If: thỏa mãi đk mới action
		for (int i = 0; i < cityName.length; i++) {
			if (cityName[i].equals("Taipei")) {
				// action
				System.out.println(cityName[i] + " is the capital of Taiwan");
				break;
			}	
		}	
	}

	// @Test
	public void TC_02_Foreach() {
		
		// Array
		String[] cityName = {"London", "Singapore", "Taipei", "HaNoi"};
		
		// Java collection
		// Class: ArrayList/ LinkedList/ Vector...
		// Interface: List/ Set/ Queue
		List<String> cityAdress = new ArrayList<String>();
		System.out.println(cityAdress.size());
		
		// Compile (Coding)
		cityAdress.add("Taichung");
		cityAdress.add("Tainan");
		System.out.println(cityAdress.size());
		
		// Runtime (Running)
		for (String cityItem : cityName) {
			cityAdress.add(cityItem);
		}
		System.out.println(cityAdress.size());
		
		for (String city : cityAdress) {
			System.out.println(city);
		}

		
		// Java Generic
		List<WebElement> links = driver.findElements(By.cssSelector(""));
		
		for (WebElement link : links) {
			// Chuyển page
			// refresh DOM/HTML
			// k tồn tại
			// fail -> StateElementException
		}
		
	}
}
