package javaException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("G:\\software.txt");
			outputStream.write(65);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void sleepInSecond(long timeout) throws InterruptedException {
		Thread.sleep(timeout * 1000);
	}

	public static void findFile() throws IOException {
		String fileName = "software.txt";
		File newFile = new File(fileName);
		if (newFile.exists() && newFile.isDirectory()) {
			// action something
		} else {
			throw new IOException("This file isn't found" + fileName);
		}
	}
}
