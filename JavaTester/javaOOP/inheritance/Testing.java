package javaOOP.inheritance;

public class Testing {

	public static void main(String[] args) {
		Testing test = new Testing();
		System.out.println(test.toString());

		Dog dog = new Dog();
		dog.setAge(1);
		System.out.println(dog.getAge());
	}

	@Override
	public String toString() {
		return "This is Software Testing";
	}

}
