package LeetCodePatterns.String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalinString {

    static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean doesOffExist = false;
        int ans = 0;
        for (Character ch : map.keySet()) {
            int count = map.get(ch);
            if (count % 2 == 0) {
                ans += count;
            } else {
                ans += (count - 1);
                doesOffExist = true;
            }
        }

        if (doesOffExist) {
            ans = ans + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String input1 = "abccccdd";
        String input2 = "aabbccdde";
        String input3 = "abc";

        System.out.println("Input: " + input1 + " -> Longest Palindrome Length: " + longestPalindrome(input1));
        System.out.println("Input: " + input2 + " -> Longest Palindrome Length: " + longestPalindrome(input2));
        System.out.println("Input: " + input3 + " -> Longest Palindrome Length: " + longestPalindrome(input3));
    }
}
