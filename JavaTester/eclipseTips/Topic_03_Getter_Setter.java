package eclipseTips;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_03_Getter_Setter {
	private String carName;
	
	WebDriver driver;
	
	// Page Object Pattern
	// Constructor
	
	// public Topic_03_Getter_Setter(WebDriver driver) {
	// this.driver = driver;
	// }
	//
	 

	// Setter
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	// Getter
	public String getCarName() {
		return this.carName;
	}

	
	@Test
	public void thread_function() throws InterruptedException {
		Thread.sleep(3000);
		
		System.out.println(driver instanceof WebDriver);
		
		System.out.println(getRandomNumber());
		
		WebDriver driver = null;
		driver.get("");
		this.driver.get("");
		
	}
	
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999);
	}	
}
