package javaOOP.polymorphism;

public class Testing {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.eat();

		animal = new Horse();
		animal.eat();

		animal = new Dog();
		animal.eat();
	}

}
