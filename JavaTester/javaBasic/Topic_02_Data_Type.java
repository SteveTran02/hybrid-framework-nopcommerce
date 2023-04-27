package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Primitive type/ value type
	// Integers
	byte bNumer = 10;
	short sNumber = 9999;
	int iNumber = 9999999;
	long lNumber = 10000000;
	// Floating-Point
	float fNumber = 99999f;
	double dNumber = 10000d;
	// Character
	char cChar = 'a';
	// Boolean
	boolean bStatus = true;

	// Reference type
	// String
	String taiwanCapital = "Taipei";
	// Array
	String[] taiwanCity = { taiwanCapital, "Tainan", "Taichung" };
	Integer[] capitalID = { 14, 15, 20 };
	// Class
	Topic_02_Data_Type topic;
	// Interface
	WebDriver driver;
	// Object
	Object objectName;
	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> checkboxes = (List<WebElement>) driver.findElement(By.cssSelector(""));
	Set<String> allIDs = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();

	public void clickToElement() {
		taiwanCapital.trim();
		taiwanCity.clone();
		driver.getCurrentUrl();
		objectName.toString();
	}

	public static void main(String[] args) {

	}

}
