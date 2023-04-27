package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {
	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01() {
		System.out.println("Please input text = ");
		String courseName = scanner.nextLine();
		System.out.println(courseName);

		char courseNameArr[] = courseName.toCharArray();
		int sumUpper = 0;
		int sumLower = 0;
		int sumNumber = 0;

		for (char course : courseNameArr) {
			// Count uppercase
			if (course >= 'A' && course <= 'Z') {
				sumUpper++;
			}

			// Count lowercase
			if (course >= 'a' && course <= 'z') {
				sumLower++;
			}

			// Count number
			if (course >= '0' && course <= '9') {
				sumNumber++;
			}
		}

		System.out.println("Sum of Uppercase = " + sumUpper);
		System.out.println("Sum of Lowercase = " + sumLower);
		System.out.println("Sum of number = " + sumNumber);
	}

	// @Test
	public void TC_02() {
		String text = "Automation Testing 345 Tutorials Online 789";
		char textArr[] = text.toLowerCase().toCharArray();
		String textSplit[] = text.split(" ");
		for (String str : textSplit) {
			if (str.equals("Testing")) {
				System.out.println("True");
			}
		}

		if (textSplit[textSplit.length - 1].equals("Online")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

		int numberA = 0;
		for (char c : textArr) {
			if (c == 'a') {
				numberA++;
			}
		}
		System.out.println("Number a = " + numberA);

		System.out.println("Index of Tutorials = " + text.indexOf("Tutorials"));

		// Replace
		text = text.replaceAll("Online", "Offline");
		System.out.println(text);

		int countNumber = 0;
		for (char count : textArr) {
			if (count >= '0' && count <= '9') {
				countNumber++;
			}
		}
		System.out.println("Count Number = " + countNumber);

	}

	@Test
	public void TC_03() {

		System.out.println("Please input text = ");
		String text = scanner.nextLine();
		System.out.println(text);
		int numberIndex = text.length();
		System.out.println(numberIndex);
		char textArr[] = text.toCharArray();

		// Reverses array and stores it in another array
		char newArr[] = new char[numberIndex];
		int j = numberIndex;

		for (int i = 0; i < textArr.length; i++) {
			newArr[j - 1] = textArr[i];
			j--;
		}

		for (char c : newArr) {
			System.out.print(c);
		}

		System.out.println("\n");
	}

}
