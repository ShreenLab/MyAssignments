package week3.week3day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingNumbers 
{

	public static void main(String[] args) 
	{
		int[] numbers =  {1, 2, 3, 4, 10, 6, 8};
		List<Integer> numList = new ArrayList<>();
		for(int i: numbers)
		{
			numList.add(i);
		}
		
		Collections.sort(numList);
		System.out.println("The ordered list is " + numList);
		
		System.out.println("Missing Numbers:");
		 for (int i = 0; i < numList.size() - 1; i++) 
	        {
	            int current = numList.get(i);
	            int next = numList.get(i + 1);
// reference table
// i current next next!=current + 1
//0 1 2 x
//1 2 3 x
//2 3 4 x
//3 4 6 5missing
//4 6 8 7missing
//5 8 10 9missing
// Check if next number is exactly 1 more than current number
	            if (next != current + 1) 
	            {
//print if doesn't match
	                System.out.println(current + 1);
	            }
	        }

}
	
}
