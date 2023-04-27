package javaBasic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Topic_12_SortListUsingJavaStreamAPI {

	public static void main(String[] args) {
		List<Integer> unsortedList = Arrays.asList(10, 1, 21, 3, 6, 2);
		// Sorting in natural order or ascending order
		List<Integer> sortedListAsc = unsortedList.stream().sorted().collect(Collectors.toList());

		System.out.println("Before sorting : " + unsortedList);
		System.out.println("After sorting  : " + sortedListAsc);

		// Sorting in descending order
		List<Integer> sortedListDesc = unsortedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		System.out.println("Before sorting : " + unsortedList);
		System.out.println("After sorting  : " + sortedListDesc);
	}
}
