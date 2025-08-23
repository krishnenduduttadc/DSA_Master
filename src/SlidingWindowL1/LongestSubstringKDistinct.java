package SlidingWindowL1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k)); // Output: 3 ("ece")
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), right);
            if (map.size() > k) {
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                left = delIndex + 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

