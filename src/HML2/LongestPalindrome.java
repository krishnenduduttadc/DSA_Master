package HML2;

import java.util.HashMap;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "banana";

        System.out.println("Length of longest palindrome in \"" + s1 + "\": " + longestPalindrome(s1));
        System.out.println("Length of longest palindrome in \"" + s2 + "\": " + longestPalindrome(s2));
    }

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder palindrome = new StringBuilder();
        boolean hasOddFrequency = false;
        char oddChar = 0;

        // Build the palindrome by placing even-count characters symmetrically
        for (char c : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(c);
            if (frequency % 2 == 0) {
                for (int i = 0; i < frequency / 2; i++) {
                    palindrome.insert(0, c); // beginning
                    palindrome.append(c);    // end
                }
            } else {
                for (int i = 0; i < (frequency - 1) / 2; i++) {
                    palindrome.insert(0, c);
                    palindrome.append(c);
                }
                if (!hasOddFrequency) {
                    hasOddFrequency = true;
                    oddChar = c;
                }
            }
        }

        // Place oddChar in the middle
        if (hasOddFrequency) {
            palindrome.insert(palindrome.length() / 2, oddChar);
        }

        System.out.println("One of the longest palindromes: " + palindrome.toString());
        return palindrome.length();
    }
}
