package week1.day4;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) 
	{
		int a[] = {1,4,3,2,8,6,7};
		//sorting array using Array.sort() method
		Arrays.sort(a);
		//iterating from 1 to 7
		for(int i =1; i<= a.length ; i++) 
		{
			if(i != a[i-1]) {
				System.out.println(i);
				break;
			}
		}
			

	}

}