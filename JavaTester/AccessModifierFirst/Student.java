package AccessModifierFirst;

public class Student {

	int age;

	// Using Setter/ Getter

	public void setAge(int enterAge) {
		if (enterAge > 0) {
			// Happy path case
			this.age = enterAge;
		} else {
			// Unhappy path case
			System.out.println("Enter age is invalid");
		}
	}

	public int getAge() {
		return this.age;
	}

}
