package javaBasic;

public class Topic_13_SubString {

	public static void main(String[] args) {
		String EMAIL_TEXTBOX = "id='Email'";
		String PASSWORD_TEXTBOX = "css=input[id='Password']";
		String LOGIN_BUTTON = "xpath=//button[text()='Log in']";
		System.out.println(EMAIL_TEXTBOX.substring(3));
		System.out.println(PASSWORD_TEXTBOX.substring(4));
		System.out.println(LOGIN_BUTTON.substring(6));
	}

}
