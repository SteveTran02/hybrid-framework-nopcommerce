package javaOOP;

public class Topic_03_Method {

	void showCarName() {
		System.out.println("Toyota");
	}

	static void showCarColor() {
		System.out.println("Blue");
	}

	public static void main(String[] args) {
		Topic_03_Method carFeature = new Topic_03_Method();
		carFeature.showCarName();
		showCarColor();
	}

}
