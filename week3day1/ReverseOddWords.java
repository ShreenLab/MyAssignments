package week3.week3day1;

public class ReverseOddWords {

    public static void main(String[] args) {

//given sentence
        String sentence = "I am a software tester";

// Split the sentence using space as delimiter
        String[] words = sentence.split(" ");

// Loop through each word using its index
        for (int i = 0; i < words.length; i++) {

// Initialize an empty string to hold the reversed word
            String reverse = " ";

// Check if the word is at an odd position
            if (i % 2 != 0) {

// Get the word at the current index
                String word = words[i];

// Convert the word into a character array for reversing
                char[] c = word.toCharArray();

// Loop through the character array in reverse order
                for (int j = c.length - 1; j >= 0; j--) {

// Append each character to the 'reverse' string
                    reverse = reverse + c[j];
                }

// Print the reversed word followed by a space
                System.out.print(reverse + " ");

            } else {
// For even positions print the word directly
                String org = words[i];

                System.out.print(org + " ");
            }
        }
    }
}
