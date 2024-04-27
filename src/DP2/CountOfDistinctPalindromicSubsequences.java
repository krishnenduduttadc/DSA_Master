package DP2;

public class CountOfDistinctPalindromicSubsequences {
    public static void main(String[] args) {
        String str = "abccba";
        int n = str.length();

        // dp[i][j] will store the count of distinct palindromic subsequences in substring str.substring(i, j + 1)
        int[][] dp = new int[n][n];

        // Fill the dp array using a bottom-up approach
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    // Single character is a palindrome by itself
                    dp[i][j] = 1;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        // If characters at ends are the same, use gap strategy to count distinct subsequences
                        int l = i + 1;
                        int r = j - 1;
                        while (l <= r && str.charAt(l) != str.charAt(i)) {
                            l++;
                        }
                        while (l <= r && str.charAt(r) != str.charAt(i)) {
                            r--;
                        }
                        if (l > r) {
                            // No repeated character found in between i and j
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if (l == r) {
                            // One repeated character found in between i and j
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            // Two repeated characters found in between i and j
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[l + 1][r - 1];
                        }
                    } else {
                        // Characters at ends are different
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }

                    // Ensure dp[i][j] is non-negative by taking modulo
                    dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
                }
            }
        }


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Count of distinct palindromic subsequences: " + dp[0][n - 1]);
    }
}
