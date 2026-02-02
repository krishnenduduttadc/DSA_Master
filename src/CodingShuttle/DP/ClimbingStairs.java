package CodingShuttle.DP;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 8;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(climbingStairsTopDown(n, dp));
        System.out.println(climbingStairsBottomUp(n));
        System.out.println(climbingStairsBottomUpOptimised(n));
    }

    static int climbingStairsTopDown(int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (dp[n] != -1) return dp[n];

//        System.out.println(n);

        return dp[n] = climbingStairsTopDown(n - 1, dp) + climbingStairsTopDown(n - 2, dp) + climbingStairsTopDown(n - 3, dp);
    }

    static int climbingStairsBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    static int climbingStairsBottomUpOptimised(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int first = 1;
        int second = 1;
        int third = 2;

        for (int i = 3; i <= n; i++) {
            int res = first + second + third;
            first = second;
            second = third;
            third = res;
        }

        return third;
    }
}
