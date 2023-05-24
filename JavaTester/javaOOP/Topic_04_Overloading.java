package javaOOP;

public class Topic_04_Overloading {

	static int methodPlus(int a, int b) {
		return a + b;
	}

	static float methodPlus(float a, float b) {
		return a + b;
	}

	public static void main(String[] args) {
		System.out.println(methodPlus(4, 5));
		System.out.println(methodPlus(4.5f, 5.4f));

		// Static way
		Topic_03_Method.showCarColor();
	}

}
