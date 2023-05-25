package javaOOP;

public class Topic_04_Non_Access_Modifier {

	// Static: Variable/ Method
	// Dùng cho tất cả các instance/ method
	// Phạm vi cho toàn bộ system sử dụng nó\
	// Có thể override được
	static String browserName = "Chrome";
	// Non-static
	String serverName = "Testing";

	// Final variable
	final String carColor = "blue";

	// Final method

	public static void main(String[] args) {
		System.out.println(browserName);
		browserName = "Firefox";
		System.out.println(browserName);
		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.serverName);

		clickToElement("radio button");
		topic.sendKeysToElement("default dropdown");

		// topic.carColor = "red";
	}

	// Static Method
	public static void clickToElement(String webElementName) {
		System.out.println(webElementName);
	}

	// Non-static Method
	public void sendKeysToElement(String webElementName) {
		System.out.println(webElementName);
	}
}
