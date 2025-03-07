package week3.week3day1;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) 
	{
		int[] arr1 = {3, 2, 11, 4, 6, 7};
		int[] arr2 = {1, 2, 8, 4, 9, 7} ;
//converting arrays to list
		List<Integer> arr1List = new ArrayList<>();
		List<Integer> arr2List = new ArrayList<>();
		for(int i:arr1) {
			arr1List.add(i);
		}
		
		for(int j:arr2)
		{
			arr2List.add(j);
		}
//for loop to find matching numbers between these lists
		for(int i=0; i < arr1List.size();i++) {
			if(arr2List.contains(arr1List.get(i)))
				{
				System.out.println(arr1List.get(i) + " ");
				}
			}
		


	}

}
