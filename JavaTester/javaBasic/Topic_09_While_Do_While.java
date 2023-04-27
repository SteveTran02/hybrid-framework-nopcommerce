package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TC_01_For();
		// TC_01_While();
		// TC_01_Do_While();
		// TC_02_While();
		// TC_03_While();

	}

	// @Test
	public static void TC_01_For() {
		System.out.println("Input number = ");
		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	// @Test
	public static void TC_01_While() {
		System.out.println("Input number = ");
		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.print(number + "  ");
			}
			number++;
		}
	}

	// @Test
	public static void TC_01_Do_While() {
		System.out.println("Input number = ");
		int number = scanner.nextInt();
		do {
			if (number % 2 == 0) {
				System.out.print(number + "  ");
			}
			number++;
		} while (number < 100);
	}

	// @Test
	public static void TC_02_While() {
		System.out.println("Input a number = ");
		int a = scanner.nextInt();

		System.out.println("Input b number = ");
		int b = scanner.nextInt();

		while (a < b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	// @Test
	public static void TC_03_While() {
		System.out.println("Input number = ");
		int n = scanner.nextInt();
		int sum = 0;
		// int i = 0;
		// while (i <= n) {
		// if (i%2!=0) {
		// System.out.println(i);
		// sum = sum + i;
		// }
		// i++;
		// }

		while (n > 0) {
			if (n % 2 != 0) {
				sum += n; // sum = sum + n
			}
			n--;
		}

		System.out.println("Sum = " + sum);
	}

	@Test
	public static void TC_04_While() {
		System.out.println("Input number = ");
		int number = scanner.nextInt();
		int i = 1;
		while (number > 0) {
			i *= number;
			number--;
		}

		System.out.println(i);

	}

}