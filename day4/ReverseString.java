package week1.day4;

public class ReverseString 
{
    public static void main(String[] args) 
    {
    	String input = "shreen";
    	int count = 0;
    	char[] charArray = input.toCharArray();
    	for(int i = 0;i<=charArray.length-1 ;i++)
    	{
    		if(charArray[i] == 'e')
    		{
    			count++;
    		}
    			
    			
    	}
    	
        System.out.print(count);
    }
}