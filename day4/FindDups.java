package week1.day4;
public class FindDups 
{
    public static void main(String[] args) 
    {
        int[] num = {2, 5, 7, 7, 5, 9, 2, 3}; 
        System.out.println("Duplicates in the array-->");

        for (int a = 0; a < num.length; a++) 
        {
            for (int b = a + 1; b < num.length; b++) 
            {
                if (num[a] == num[b]) 
                {
                    System.out.println(num[a]);
                }
            }
        }
    }
}