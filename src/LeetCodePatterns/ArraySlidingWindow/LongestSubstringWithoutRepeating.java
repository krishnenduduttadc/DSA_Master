package LeetCodePatterns.ArraySlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1)); // Expected: 3 ("abc")

        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2)); // Expected: 1 ("b")

        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3)); // Expected: 3 ("wke")

        String s4 = "";
        System.out.println(solution.lengthOfLongestSubstring(s4)); // Expected: 0
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int fp = 0;  // left pointer

        for (int sp = 0; sp < s.length(); sp++) {
            char ch = s.charAt(sp);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // shrink window until it's valid (all unique)
            while (map.get(ch) > 1) {
                char leftChar = s.charAt(fp);
                map.put(leftChar, map.get(leftChar) - 1);
                fp++;
            }

            ans = Math.max(ans, sp - fp + 1);
        }

        return ans;
    }
}

