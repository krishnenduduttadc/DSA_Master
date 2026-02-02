package CodingShuttle.DP;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {2, 1, 40, 0, 1, 10};
        System.out.println(maxSumIncSubsequence(a));
    }

    static int maxSumIncSubsequence(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = a[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
        }

        int max = 0;
        for (int e : dp) {
            max = Math.max(max, e);
        }
        return max;
    }
}
