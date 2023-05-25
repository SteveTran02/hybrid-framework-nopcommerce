package javaOOP;

public class Testing extends Animal {

	public static void main(String[] args) {
		// Truy cập trực tiếp từ tên class
		// Không cần tạo instance/ object
		// Không nên lạm dụng tạo các biến là static

		System.out.println(Topic_04_Non_Access_Modifier.browserName);
		Topic_04_Non_Access_Modifier.browserName = "Internet Explorer";
		System.out.println(Topic_04_Non_Access_Modifier.browserName);

		// Khởi tạo các class
		Topic_04_Non_Access_Modifier.clickToElement("click to dropdown list");

		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.carColor);

	}

	// static class_ nestedclass
	public static void NestedTesting() {

	}

	@Override
	public void setAnimalName() {
		// TODO Auto-generated method stub

	}
}
