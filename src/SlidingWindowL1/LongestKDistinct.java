package SlidingWindowL1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestKDistinct {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), right);

            if (map.size() > k) {
                int minIndex = Collections.min(map.values());
                map.remove(s.charAt(minIndex));
                left = minIndex + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println("Longest substring with at most " + k + " distinct chars = " + maxLen);
    }
}

