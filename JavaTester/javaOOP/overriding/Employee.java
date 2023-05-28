package javaOOP.overriding;

public class Employee extends Person implements IWorking {

	@Override
	public void eat() {
		System.out.println("Lunch box price is 35.000k");
	}

	@Override
	public void sleep() {
		System.out.println("Sleep hours is 7 hours");
	}

	@Override
	public void workingTime() {
		System.out.println("Working hours is 8 hours");
	}
}