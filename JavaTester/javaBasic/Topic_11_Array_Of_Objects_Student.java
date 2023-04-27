package javaBasic;

public class Topic_11_Array_Of_Objects_Student {

	int ID, age;
	String studentName;
	double score;

	public Topic_11_Array_Of_Objects_Student(int ID, String studentName, int age, double score) {
		this.ID = ID;
		this.studentName = studentName;
		this.age = age;
		this.score = score;
	}

	public void display() {
		System.out.println("Student ID: " + ID);
		System.out.println("Student name: " + studentName);
		System.out.println("Student age: " + age);
		System.out.println("Student score: " + score);
	}
	
	public static void main(String[] args) {
		Topic_11_Array_Of_Objects_Student[] students = new Topic_11_Array_Of_Objects_Student[4];
		
		students[0] = new Topic_11_Array_Of_Objects_Student(1, "Steve", 20, 8);
		students[1] = new Topic_11_Array_Of_Objects_Student(2, "Son", 21, 9);
		students[2] = new Topic_11_Array_Of_Objects_Student(3, "Derek", 22, 8.5);
		students[3] = new Topic_11_Array_Of_Objects_Student(4, "Victor", 23, 9.5);
		
		// Print
		for (Topic_11_Array_Of_Objects_Student std : students) {
			std.display();
			System.out.println("\n");
		}	
	}
}
