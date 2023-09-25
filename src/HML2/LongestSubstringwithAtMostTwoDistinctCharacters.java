package HML2;

import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        String s = "abccccccghi";
        System.out.println(sol(s));
    }

    static int sol(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int dis = 0;
        int start = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int fre = count.getOrDefault(s.charAt(i), 0);
            if (fre == 0) dis++;
            count.put(s.charAt(i), fre + 1);
            while (dis > 2) {
                fre = count.get(s.charAt(start));
                count.put(s.charAt(start), fre - 1);
                if (fre - 1 == 0) {
                    dis--;
                }
                start++;
            }
            ans = Math.max(ans, i - start + 1);

        }
        return ans;
    }
}
