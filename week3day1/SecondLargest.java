package week3.week3day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargest {

	public static void main(String[] args) 
	{
		List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 2, 11, 4, 6, 7));
		Collections.sort(numbers);
		int secondLargest = numbers.get(numbers.size()-2);
		System.out.println("The second largest number is " + secondLargest);
		

	}

}
