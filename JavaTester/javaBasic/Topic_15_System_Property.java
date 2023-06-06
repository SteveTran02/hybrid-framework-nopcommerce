package javaBasic;

import java.io.File;

public class Topic_15_System_Property {
	private static final String PROJECT_PATH = System.getProperty("user.dir");
	private static final String OS_NAME = System.getProperty("os.name");

	// Window/ Mac/ Linux
	private static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

	public static void main(String[] args) {
		System.out.println(PROJECT_PATH);
		System.out.println(OS_NAME);
		System.out.println(UPLOAD_FILE_FOLDER);
	}

}
