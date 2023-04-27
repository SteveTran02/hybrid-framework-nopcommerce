package javaBasic;

import java.util.Scanner;

public class Topic_01_Variable {
	static int numberStudentID;
	static boolean areYouStudent;
	static final String BROWSER_NAME = "Firefox"; // constant

	String studentName = "Pure Insight";
	static int studentID;

	public static void main(String[] args) {
		System.out.println("numberStudentID = " + numberStudentID);
		System.out.println("areYouStudent = " + areYouStudent);
		// BROWSER_NAME = "Chrome";

		Topic_01_Variable topic = new Topic_01_Variable();
		System.out.println(topic.studentID);

		// Input
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		int age = scanner.nextInt();
		float salary = scanner.nextFloat();

	}

	// Getter: getCurrentUrl/ getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/ getPosition/...
	public String getStudentName() {
		return this.studentName;
	}

	// Setter: click/ sendKeys/ clear/ select/ back/ forward/ refresh/ get/...
	public void getStudentName(String stdName) {
		this.studentName = stdName;
	}
}
