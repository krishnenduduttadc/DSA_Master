package LeetCodePatterns.DP;

import java.util.Arrays;

public class LCS {

    private int[][] dp;

    public static void main(String[] args) {
        LCS solver = new LCS();

        String s1 = "abcde", s2 = "ace";
        System.out.println("LCS length (abcde, ace): " + solver.longestCommonSubsequence(s1, s2));
        // Expected: 3 ("ace")

        String s3 = "abc", s4 = "abc";
        System.out.println("LCS length (abc, abc): " + solver.longestCommonSubsequence(s3, s4));
        // Expected: 3

        String s5 = "abc", s6 = "def";
        System.out.println("LCS length (abc, def): " + solver.longestCommonSubsequence(s5, s6));
        // Expected: 0
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lcs(text1, text2, n - 1, m - 1);
    }

    private int lcs(String text1, String text2, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (dp[i][j] == -1) {
            if (text1.charAt(i) == text2.charAt(j)) {
                dp[i][j] = 1 + lcs(text1, text2, i - 1, j - 1);
            } else {
                dp[i][j] = Math.max(
                        lcs(text1, text2, i - 1, j),
                        lcs(text1, text2, i, j - 1)
                );
            }
        }
        return dp[i][j];
    }
}
