package javaBasic;

public class Topic_03_Compare {
	int number = 9;
	public static void main(String[] args) {
		// Primitive variable
		int x = 10;
		int y = x;
		
		// Before 
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		y = 5;
		// After
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		// Reference variable
		Topic_03_Compare firstVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = firstVariable;
		// Before 
		System.out.println("Before = " + firstVariable.number);
		System.out.println("Before = " + secondVariable.number);
		secondVariable.number = 5;
		// After
		System.out.println("After = " + firstVariable.number);
		System.out.println("After = " + secondVariable.number);
	}
}