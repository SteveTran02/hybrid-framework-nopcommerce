package javaOOP.abstraction;

public class Laptop extends Computer {

	@Override
	public void setRam() {
		System.out.println("Ram DDR4 - 3200");
	}

	public void showCPUBrain() {
		showCPU();
	}
}
