package CodingShuttle.Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String s = "abcdcbeccada";
        System.out.println(longestUniqueSubstring(s));
    }

    static int longestUniqueSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        while (r < s.length()) {
            if (!map.containsKey(s.charAt(r)) || map.get(s.charAt(r)) < l) {
                ans = Math.max(ans, r - l + 1);
            } else {
                l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            r++;
        }
        return ans;
    }
}
