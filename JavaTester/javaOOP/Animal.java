package javaOOP;

// Abstract class
// Template
public abstract class Animal {

	// Variable
	String animalName = "dog";

	// Abstract method
	// Using only access modifier: public and protected
	// Bắt buộc subclass phải override method lại
	public abstract void setAnimalName();

}
