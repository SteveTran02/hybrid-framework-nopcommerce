package javaOOP.overriding;

public class Student extends Person implements IWorking {

	@Override
	public void eat() {
		System.out.println("Lunch box price is 15.000k");
	}

	@Override
	public void sleep() {
		System.out.println("Sleep hours is 10 hours");
	}

	@Override
	public void workingTime() {
		System.out.println("Working hours is 6 hours");
	}
}
