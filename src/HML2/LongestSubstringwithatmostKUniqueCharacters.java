package HML2;

import java.util.HashMap;

public class LongestSubstringwithatmostKUniqueCharacters {
    public static void main(String[] args) {
        String str = "ddacbbaccdedacebb";
        int k = 3;
        System.out.println(longestSubstringAtMostK(str, k));
    }

    static int longestSubstringAtMostK(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


}
