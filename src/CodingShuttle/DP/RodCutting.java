package CodingShuttle.DP;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int[] v = {1, 4, 8, 9, 10, 1, 7, 0};
        int n = 8;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(rodCuttingProblem(n, v, n, dp));
        System.out.println(rodCuttingProblemBottomUp(n, v));
    }

    static int rodCuttingProblem(int n, int[] v, int i, int[] dp) {
        if (i <= 0) return 0;

        if (dp[i] != -1) return dp[i];

        int max = 0;
        for (int len = 1; len <= i; len++) {
            int profitAtThisCut = v[len - 1] + rodCuttingProblem(n, v, i - len, dp);
            max = Math.max(max, profitAtThisCut);
        }

        return dp[i] = max;
    }

    static int rodCuttingProblemBottomUp(int n, int[] v) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = v[0];

        for (int i = 2; i <= n; i++) {
            for (int cut = 1; cut <= i; cut++) {
                dp[i] = Math.max(dp[i], v[cut - 1] + dp[i - cut]);
            }
        }

        for (int e : dp) {
            System.out.print(e + " ");
        }

        return dp[n];
    }
}
