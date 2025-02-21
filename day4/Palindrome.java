package week1.day4;

public class Palindrome 
{

	public static void main(String[] args) 
	{
		int number = 12345;
		int reverse =0;
		for(int i=12345; i>0; i /= 10) 
		{
			int digit = i % 10;
			reverse = reverse * 0 + digit;
			System.out.print(reverse);
			
		}
	}
}