package javaOOP;

public class Testing {

	public static void main(String[] args) {
		Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();
		topic.setPersonName("Pure");
		topic.setPersonAge(20);
		topic.setPersonBankAccountMount(10);

		System.out.println(topic.getPersonName());
		System.out.println(topic.getPersonAge());
		System.out.println(topic.getPersonPhone());
		System.out.println(topic.getPersonBankAccountMount());
	}

}
