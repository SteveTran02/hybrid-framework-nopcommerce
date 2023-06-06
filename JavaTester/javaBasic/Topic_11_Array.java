package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.testng.annotations.Test;

import commons.GlobalConstants;

public class Topic_11_Array {

	// @Test
	public void TC_01_Declaration_1D_Array() {
		// Declaration one dimensional array also know 1D Array
		String studentName[] = { "Steve", "Derek", "Husun", "Son" };

		String teacherName[] = new String[4];
		// Initialization
		for (int i = 0; i < teacherName.length; i++) {
			teacherName[i] = studentName[i];
		}

		// Print
		for (int i = 0; i < teacherName.length; i++) {
			System.out.println(teacherName[i]);
		}

	}

	// @Test
	public void TC_02_List_Of_Even_Number() {
		// Program to input 10 numbers in an array and display only the even numbers if present in the array
		int arrayint[] = new int[10];

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 10 numbers");

		for (int i = 0; i < 10; i++) {
			arrayint[i] = scanner.nextInt();
		}

		System.out.println("List of even number");
		for (int i = 0; i < 10; i++) {
			if (arrayint[i] % 2 == 0) {
				System.out.print(arrayint[i] + "   ");
			}
		}
	}

	// @Test
	public void TC_03_Array_List() {

		// Compile
		// Được define cố định bao nhiêu phần tử khi viết code _ compile
		String studentName[] = { "Steve", "Derek", "Husun", "Son" };

		ArrayList<String> stdName = new ArrayList<String>();
		// Runtime
		// Khi chạy code mới add
		for (String std : studentName) {
			stdName.add(std);
		}
		// Print
		for (String std : studentName) {
			System.out.println(std);
		}
	}

	// @Test
	public void TC_04_Phuong_Thuc_Cua_Mang() {

		// Covert Array to List
		// List<String> names = Arrays.asList{"Steve", "Derek", "Husun", "Son"};
		// for (String name : names) {
		// System.out.println(name); }

		// Compare with 2 arrays
		int a[] = { 1, 2, 3 };
		int b[] = { 1, 2, 3 };
		System.out.println(Arrays.equals(a, b));

		// Gán cùng giá trị cho phần tử của mảng
		int fillArray[] = new int[5];
		Arrays.fill(fillArray, 9);
		for (int i : fillArray) {
			System.out.println(i);
		}

		// Sort 1D array
		int years[] = { 2000, 2023, 2008, 2010, 2001 };
		Arrays.sort(years);
		for (int year : years) {
			System.out.println(year);
		}

		// Chuyển mảng thành chuỗi _ toString
		String yearsString = Arrays.toString(years);
		System.out.println("yearsString = " + yearsString);

	}

	@Test
	public void TC_05() {
		String fileName[] = { "caohung.jpg", "dainam.jpg", "taipei.jpg" };
		String path = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileName) {
			fullFileName = fullFileName + path + file + "\n";
		}
		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
	}
}
