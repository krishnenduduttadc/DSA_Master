package CodingShuttle.DP;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("i");
        set.add("like");
        set.add("sam");
        set.add("sung");

        String s = "ilike";
        Boolean[] dp = new Boolean[s.length()];

        System.out.println(wordBreak(set, s, 0, dp));
        System.out.println(wordBreakBottomUp(set, s));
    }

    static boolean wordBreak(Set<String> set, String s, int i, Boolean[] dp) {
        if (i == s.length()) return true;
        if (dp[i] != null) return dp[i];

        for (int j = i; j < s.length(); j++) {
            String cur = s.substring(i, j + 1);
            if (set.contains(cur)) {
                if (wordBreak(set, s, j + 1, dp)) return dp[i] = true;
            }
        }
        return dp[i] = false;
    }

    static boolean wordBreakBottomUp(Set<String> set, String s) {
        boolean[] dp = new boolean[s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                String cur = s.substring(i, j + 1);
                if (set.contains(cur)) {
                    if (i == 0) {
                        dp[j] = true;
                        break;
                    }
                    if (dp[i - 1]) {
                        dp[j] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}
