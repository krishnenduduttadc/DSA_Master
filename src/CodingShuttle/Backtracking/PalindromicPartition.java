package CodingShuttle.Backtracking;

import java.util.Arrays;

public class PalindromicPartition {
    public static void main(String[] args) {
        String s = "abcbadcp";
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] e : dp) Arrays.fill(e, -1);

        System.out.println(palindromicPartitioning(s, 0, s.length() - 1, dp));
        System.out.println(palindromicPartitioning(s));

    }

    static void fillPalindromeMatrix(String s, boolean[][] pal, int n) {
        for (int i = 0; i < n; i++) pal[i][i] = true;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (pal[i + 1][j - 1] || len == 2)) {
                    pal[i][j] = true;
                }
            }
        }
    }

    static int palindromicPartitioning(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        fillPalindromeMatrix(s, pal, n);

        int[] dp = new int[n];
        for (int j = 1; j < n; j++) {
            if (pal[0][j]) dp[j] = 0;
            else {
                int min = Integer.MAX_VALUE;
                for (int i = j; i >= 0; i--) {
                    if (pal[i][j]) {
                        min = Math.min(min, dp[i - 1] + 1);
                    }
                }
                dp[j] = min;
            }
        }
        return dp[n - 1];
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    static int palindromicPartitioning(String s, int i, int j, int[][] dp) {
        if (i >= j || isPalindrome(s, i, j)) return 0;

        if (dp[i][j] != -1) return dp[i][j];
//        System.out.println(i+" "+j);

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min,
                    palindromicPartitioning(s, i, k, dp) + palindromicPartitioning(s, k + 1, j, dp) + 1);
        }
        return dp[i][j] = min;
    }
}
