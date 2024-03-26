package HML2;

import java.util.HashMap;

public class LongestSubstringTwoDistinct {
    public static void main(String[] args) {
        String str1 = "eceba";
        String str2 = "ccaabbb";

        System.out.println("Longest substring with at most two distinct characters in \"" + str1 + "\": " + lengthOfLongestSubstringTwoDistinct(str1));
        System.out.println("Longest substring with at most two distinct characters in \"" + str2 + "\": " + lengthOfLongestSubstringTwoDistinct(str2));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Acquire: Add current character to the window
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // Release: If window contains more than two distinct characters, move the start pointer forwar until the window contains at most two distinct characters
            while (map.size() > 2) {
                char charToRemove = s.charAt(j);
                map.put(charToRemove, map.get(charToRemove) - 1);
                if (map.get(charToRemove) == 0) {
                    map.remove(charToRemove);
                }
                j++;
            }

            maxLength=Math.max(maxLength,i-j+1);
        }
        return maxLength;
    }
}
