package HML2;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";

        System.out.println("Longest substring without repeating characters in \"" + str1 + "\": " + lengthOfLongestSubstring(str1));
        System.out.println("Longest substring without repeating characters in \"" + str2 + "\": " + lengthOfLongestSubstring(str2));
        System.out.println("Longest substring without repeating characters in \"" + str3 + "\": " + lengthOfLongestSubstring(str3));
    }



    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the current character is already in the substring, adjust the start pointer
            if (map.containsKey(currentChar)) {
                start = Math.max(map.get(currentChar) + 1, start);
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);

            // Store the index of the current character in the map
            map.put(currentChar, end);
        }

        return maxLength;
    }
}
