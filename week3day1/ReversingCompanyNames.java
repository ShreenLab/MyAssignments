package week3.week3day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReversingCompanyNames {

	public static void main(String[] args) 
	{
		String companyNames[] = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		
		List<String> names = new ArrayList<String>(Arrays.asList(companyNames));
		Collections.sort(names);
		Collections.reverse(names);
		for(String i :names) {
			System.out.println(i + ",");
			
		}
		
		

	}

}
