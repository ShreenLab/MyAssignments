package week1.day3;

public class IsPrimeNumber 
{
    public static void main(String[] args) 
    {
        int num = 13;
        boolean isPrime = true;//assume number is prime
        for (int i = 2; i <= (num / 2); i++) 
        {
            if (num % i == 0) 
            { 
                isPrime = false;
                break;
            }
        }

        
        if (isPrime) 
        {
            System.out.println(num + " is a Prime Number");
        } 
        else 
        {
            System.out.println(num + " is NOT a Prime Number");
        }
    }
}