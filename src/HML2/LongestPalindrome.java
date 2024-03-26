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

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int maxLength = 0;
        StringBuilder palindrome = new StringBuilder(); // To store one of the longest palindromes

        boolean hasOddFrequency = false;

        // Iterate through the frequencies
        for (char c : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(c);
            if (frequency % 2 == 0) {
                // Add characters to both ends of the palindrome for even frequency
                for (int i = 0; i < frequency; i++) {
                    palindrome.insert(0, c); // Add characters to the beginning of the palindrome
                    palindrome.append(c); // Add characters to the end of the palindrome
                }
            } else {
                // Add characters to both ends of the palindrome except for one character for odd frequency
                for (int i = 0; i < frequency - 1; i++) {
                    palindrome.insert(0, c); // Add characters to the beginning of the palindrome
                    palindrome.append(c); // Add characters to the end of the palindrome
                }
                hasOddFrequency = true;
            }
        }

        // If there are characters with odd frequencies, add one of them to the middle of the palindrome
        if (hasOddFrequency) {
            palindrome.insert(palindrome.length() / 2, s.charAt(0));
            maxLength++;
        }

        System.out.println("One of the longest palindromes: " + palindrome.toString());
        return Math.min(palindrome.length(), s.length());
    }
}
