package javaOOP.inheritance;

public class Animal {

	public Animal() {
		System.out.println("Parent's constructor");
	}

	public Animal(String animalName) {
		System.out.println("Parent's constructor" + animalName);
	}

	public Animal(String animalName, int animalAge) {
		System.out.println("Parent's constructor" + animalName);
		System.out.println("Parent's constructor" + animalAge);
	}

}
