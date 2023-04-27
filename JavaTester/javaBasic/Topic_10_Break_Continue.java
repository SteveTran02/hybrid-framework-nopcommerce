package javaBasic;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {

		// Nest for
		for (int i = 0; i <= 9; i++) {
			System.out.println("Apply for i =" + i);
			
			for (int j = 0; j < 5; j++) {
				if (j == 4) {
					// Loại trừ 1 đk này ra
					continue;
				}
				System.out.println("j =" + j);
			}	
		}
	}
}
