package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_Array_Exercises {

	// @Test
	public void TC_01_Find_The_Maximum_Number() {
		int arrNumber[] = new int[9];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 9 numbers");

		for (int i = 0; i < arrNumber.length; i++) {
			arrNumber[i] = scanner.nextInt();
		}

		// Print array number
		for (int i : arrNumber) {
			System.out.println(i);
		}

		int maxNumber = 0;
		for (int i : arrNumber) {
			if (i > maxNumber) {
				maxNumber = i;
			}
		}
		System.out.println("Find the maximum number = " + maxNumber);
	}

	// @Test
	public void TC_02() {
		int arrNumber[] = new int[9];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 9 numbers");

		for (int i = 0; i < arrNumber.length; i++) {
			arrNumber[i] = scanner.nextInt();
		}

		// Sum of first element and final element
		int sum = arrNumber[0] + arrNumber[arrNumber.length - 1];

		System.out.println("Sum = " + sum);
	}

	// @Test
	public void TC_03_List_Of_Even_Number() {
		int arrNumber[] = new int[9];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 9 numbers");

		for (int i = 0; i < arrNumber.length; i++) {
			arrNumber[i] = scanner.nextInt();
		}

		// Print array number
		for (int i : arrNumber) {
			System.out.println(i);
		}

		// List of even number
		System.out.println("List of even number");
		for (int i : arrNumber) {
			if (i % 2 == 0) {
				System.out.print(i + "  ");
			}
		}
	}

	// @Test
	public void TC_04_Sum_Of_Odd_Numbers() {
		int arrNumber[] = new int[9];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 9 numbers");

		for (int i = 0; i < arrNumber.length; i++) {
			arrNumber[i] = scanner.nextInt();
		}

		// Print array number
		for (int i : arrNumber) {
			System.out.println(i);
		}

		// Sum_Of_Odd_Numbers
		int sumOfOddNumber = 0;
		for (int i : arrNumber) {
			if (i > 0 && (i % 2 != 0)) {
				sumOfOddNumber += i;
			}
		}
		System.out.println("Sum_Of_Odd_Numbers = " + sumOfOddNumber);
	}

	// @Test
	public void TC_05() {
		int arrNumber[] = new int[9];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 9 numbers");

		for (int i = 0; i < arrNumber.length; i++) {
			arrNumber[i] = scanner.nextInt();
		}

		// Print array number
		for (int i : arrNumber) {
			System.out.println(i);
		}

		// Numbers of [0;10]
		for (int i : arrNumber) {
			if (i >= 0 && i <= 10) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void TC_06_Sum_And_Average() {
		int arrNumber[] = new int[9];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 9 numbers");

		for (int i = 0; i < arrNumber.length; i++) {
			arrNumber[i] = scanner.nextInt();
		}

		// Print array number
		for (int i : arrNumber) {
			System.out.println(i);
		}

		// Sum of array numbers
		int sum = 0;
		for (int i : arrNumber) {
			sum += i;
		}
		System.out.println("Sum_Of_Array_Numbers = " + sum);

		// Average of array numbers
		float averageArrayNumber = sum / arrNumber.length;
		System.out.println("Average = " + averageArrayNumber);
	}

}
