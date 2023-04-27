package javaBasic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_04_Operator {

	public static void main(String[] args) {
		int number = 9;
		System.out.println(number++);
		System.out.println(++number);
		
		for (int i = 0; i <=5; i++) {
			System.out.print(i + "  ");
		}	
		System.out.println();
		
		Assert.assertTrue(5 < 6);
		
		String cityName = "Taipei";
		if( !(cityName=="Tainam") ) {
			System.out.println("City isn't the same!");
		} else {
			System.out.println("City is the capital of Taiwan");
		}
		
		// Tam nguyên_  = ? : 
		boolean status = (cityName!="Tainam") ? true : false;
		System.out.println("Status is " + status);
		
		
	}
	
	@Test
	public void TC_01() {
		int a = 6;
		int b = 2;
		System.out.println("Addition = " + (a + b));
		System.out.println("Subtraction = " + (a - b));
		System.out.println("Multiplication = " + (a * b));
		System.out.println("Division = " + (a / b));
	}
}
