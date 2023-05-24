package javaOOP;

public class Topic_02_Variable_Property_Method {

	// Access Modifier
	// Non-access modifier: static or final
	// Variable name
	// Variable value

	// Global variable
	private String studentName = "Steven";

	// Static variable: using and assigned
	public static String studentAddress = "London";
	private static String studentPhoneNumber = "0123456789";

	// Final variable
	final String countryName = "Germany";

	// Static final variable - Constant
	static final float PI_NUMBER = 3.1415f;

	private static int studentNumber;
	private static boolean studentStatus;
	private static String studentObject;

	protected Topic_02_Variable_Property_Method() {
		// countryName = "Taiwan";
		// The final field cannot be assigned

	}

	public static void main(String[] args) {
		studentAddress = "Tainan";
		studentPhoneNumber = "987654321";
		System.out.println(studentNumber);
		System.out.println(studentStatus);
		System.out.println(studentObject);
	}

}
