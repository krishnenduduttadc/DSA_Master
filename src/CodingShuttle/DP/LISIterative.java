package CodingShuttle.DP;

import java.util.Arrays;

public class LISIterative {
    public static void main(String[] args) {
        int[] a = {2, 1, 40, 0, 1, 10};
        System.out.println(lisBottomUp(a));
    }

    static int lisBottomUp(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
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
