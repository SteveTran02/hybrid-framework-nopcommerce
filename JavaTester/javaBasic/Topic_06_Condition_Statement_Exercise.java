package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement_Exercise {

	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
		
	public void TC_01() {
		System.out.print("Input one number = ");
		int number = scanner.nextInt();
		if (number%2==0) {
			System.out.println("Number " + number + " is even");
		} else {
			System.out.println("Number " + number + " is odd");
		}
	}
	
	public void TC_02() {
		System.out.print("Input first number = ");
		int Number1 = scanner.nextInt();
		
		System.out.print("Input second number = ");
		int Number2 = scanner.nextInt();
		
		if (Number1 > Number2) {
			System.out.print(Number1 + " > " + Number2);
		} else if (Number1 == Number2) {
			System.out.println(Number1 + " = " + Number2);
		} else {
			System.out.println(Number1 + " < " + Number2);
		}
	}

	public void TC_03() {
		System.out.print("Input name of student A is ");
		String student1 = scanner.nextLine();
		
		System.out.print("Input name of student B is ");
		String student2 = scanner.nextLine();
		
		if (student1.equals(student2)) {
			System.out.println("Two student have same name");
		} else {
			System.out.println("Two student have different name");
		}	
	}
	
	public void TC_04() {
		System.out.print("Input first number = ");
		int Number1 = scanner.nextInt();
		
		System.out.print("Input second number = ");
		int Number2 = scanner.nextInt();
		
		System.out.print("Input third number = ");
		int Number3 = scanner.nextInt();
		
		if (Number1 > Number2 && Number1 > Number3) {
			System.out.println(Number1 + " is max");
		} else if (Number2 > Number1 && Number2 > Number3) {
			System.out.println(Number2 + " is max");
		} else {
			System.out.println(Number3 + " is max");
		}

	}
	
	public void TC_05() {
		System.out.print("Input number = ");
		int Number = scanner.nextInt();
		if (Number < 10 && Number > 100) {
			System.out.print("10 <" + Number + " < 100");
		} else {
			System.out.print(Number + " < 10 or " + Number + " > 100");
		}
    }

	public void TC_06() {
		System.out.print("Input number = ");
		float Number = scanner.nextFloat();
		if ( Number < 0) {
			System.out.print("input invalid data, please try again!");
		} else	if (Number >= 0 && Number <= 5) {
			System.out.print("Grade D");
		} else if (Number > 5 && Number <= 7.5) {
			System.out.print("Grade C");
		} else if (Number > 7.5 && Number <= 8.5) {
			System.out.print("Grade B");
		} else if (Number > 8.5 && Number <= 10) {
			System.out.print("Grade A");
		} else {
			System.out.print("input invalid data, please try again!");
		}
    }

	@Test
	public void TC_07() {
		System.out.print("Input month = ");
		int month = scanner.nextInt();
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Month " + month + "have 31 days");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Month " + month + "have 30 days");
		} else if (month == 2) {
			System.out.println("Month " + month + " have 28 days or 29 days");
		}
    }
}