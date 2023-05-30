package javaOOP.abstraction;

public abstract class Computer {

	// Non-abstract method
	public void showCPU() {
		System.out.println("Intel Core i5-10300H");
	}

	// Abstract method
	public abstract void setRam();

}
