package week1.day4;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) 
	{
		 String test = "changeme";
		 char[] charArray = test.toCharArray();
		 for(int i=1; i < charArray.length ; i+=2)
		 {
			 charArray[i] = Character.toUpperCase(charArray[i]);
		 }
		 String result = new String(charArray);
		 System.out.println(result);
	}

}
