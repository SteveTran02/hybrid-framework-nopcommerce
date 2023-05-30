package javaOOP.inheritance;

public class Dog extends Animal {

	int age;

	public Dog() {
		super("buffalo", 5);
		System.out.println("Child's constructor");
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			this.age = 0;
		}
	}

	public int getAge() {
		return this.age;
	}

}
