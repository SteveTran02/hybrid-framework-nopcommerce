package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_Demo_Convert_String_To_Int {
	String results = "Viewing 48 of 134 results";
	
	@Test
	public void TC_Get_Int_From_String() {
		String result[] = results.split(" ");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println(extractNumberFromString(results, 1));
		System.out.println(extractNumberFromString(results, 3));
		System.out.println(Integer.parseInt(result[1]));
		System.out.println(Integer.parseInt(result[3]));

	
	}

	public int extractNumberFromString(String results, int number) {
		String result[] = results.split(" ");
		int getInt = Integer.parseInt(result[number]);
		return getInt;	
	}
}
