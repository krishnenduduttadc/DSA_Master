package CodingShuttle.DP;

import java.util.Arrays;

public class CountBSTnKey {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(countBSTs(4, dp));
        System.out.println(countBSTsBottomUp(4));
    }

    // Top-down (Memoization) approach
    static int countBSTs(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += countBSTs(i - 1, dp) * countBSTs(n - i, dp);
        }
        return dp[n] = count;
    }

    // Bottom-up (Dynamic Programming) approach
    static int countBSTsBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                count += dp[j - 1] * dp[i - j];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
