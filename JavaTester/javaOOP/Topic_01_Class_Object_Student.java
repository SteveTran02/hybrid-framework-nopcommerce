package javaOOP;

public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentName;
	private Float studentPointFirst, studentPointSecond;
	private Float studentPointAverage;

	protected Topic_01_Class_Object_Student(int studentID, String studentName, Float studentPointFirst, Float studentPointSecond, Float studentPointAverage) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentPointFirst = studentPointFirst;
		this.studentPointSecond = studentPointSecond;
		this.studentPointAverage = studentPointAverage;
	}

	protected int getStudentID() {
		return studentID;
	}

	protected void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	protected String getStudentName() {
		return studentName;
	}

	protected void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	protected Float getStudentPointFirst() {
		return studentPointFirst;
	}

	protected void setStudentPointFirst(Float studentPointFirst) {
		this.studentPointFirst = studentPointFirst;
	}

	protected Float getStudentPointSecond() {
		return studentPointSecond;
	}

	protected void setStudentPointSecond(Float studentPointSecond) {
		this.studentPointSecond = studentPointSecond;
	}

	protected Float getStudentPointAverage() {
		this.studentPointAverage = (this.studentPointFirst + this.studentPointSecond * 2) / 3;
		return studentPointAverage;
	}

	protected void showStudentStatus() {
		System.out.println("StudentID is " + getStudentID());
		System.out.println("Student name is " + getStudentName());
		System.out.println("Student Point First is " + getStudentPointFirst());
		System.out.println("Student Point Second is " + getStudentPointSecond());
		System.out.println("Student Point Avarage is " + getStudentPointAverage() + "\n");
	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student studentFirstStatus = new Topic_01_Class_Object_Student(1, "Steve", 8.5f, 8.5f, 8.5f);
		studentFirstStatus.showStudentStatus();

		Topic_01_Class_Object_Student studentSecondStatus = new Topic_01_Class_Object_Student(2, "William", 9.5f, 9.5f, 8.5f);
		studentSecondStatus.showStudentStatus();

		Topic_01_Class_Object_Student studentThirdStatus = new Topic_01_Class_Object_Student(3, "Steve", 7.5f, 8.5f, 7.5f);
		studentThirdStatus.showStudentStatus();
	}

}
