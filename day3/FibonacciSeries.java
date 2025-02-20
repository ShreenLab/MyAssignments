package week1.day3;

public class FibonacciSeries 
{
	public static void main(String[] args) 
	{
		int range=8,x=0,y=1,z;
		for(int i=0;i<range;i++) 
		{
			System.out.print(x + ",");
			z=x+y;
			x=y;
			y=z;
		}
	}

}