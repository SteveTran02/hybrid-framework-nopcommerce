package javaBasic;

public class Topic_05_Primitive_Casting {

	public static void main(String[] args) {

		// Ngầm định_Implicit = không mất dữ liệu
		// byte bNumer = 99;
		// System.out.println(bNumer);
		// short sNumber = bNumer;
		// System.out.println(sNumber);
		// int iNumber = sNumber;
		// System.out.println(iNumber);
		// long lNumber = iNumber;
		// System.out.println(lNumber);
		// float fNumber = lNumber;
		// System.out.println(fNumber);
		// double dNumber = fNumber;
		// System.out.println(dNumber);
		//
		// Tường minh_Explicit - mất dữ liệu
		double dNumber = 9999999999999d;
		System.out.println(dNumber);
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		long lNumber = (long) fNumber;
		System.out.println(lNumber);
		int iNumber = (int) lNumber;
		System.out.println(iNumber);

		char c = (char) -123;
		System.out.println(c);

	}

}
