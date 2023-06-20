package DP2;

public class CountPalindromicSubseq {
    public static void main(String[] args) {
        String str = "abccbc";
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        System.out.println(dp[0][str.length() - 1]);
    }
}
