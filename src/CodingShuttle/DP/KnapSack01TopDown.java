package CodingShuttle.DP;

import java.util.Arrays;

public class KnapSack01TopDown {
    public static void main(String[] args) {

        int[] w = {1, 2, 3};
        int[] v = {30, 40, 60};
        int W = 4;

        System.out.println(zeroOneKnapsack(w, v, W));
    }

    static int zeroOneKnapsack(int[] w, int[] v, int W) {
        int[][] dp = new int[v.length][W + 1];
        for (int[] e : dp) Arrays.fill(e, -1);
        zeroOneKnapsack(w, v, W, w.length - 1, dp);
        return dp[v.length - 1][W];
    }

    static int zeroOneKnapsack(int[] w, int[] v, int W, int i, int[][] dp) {
        if (i == -1) return 0;

        if (dp[i][W] != -1) return dp[i][W];

        if (w[i] > W) return dp[i][W] = zeroOneKnapsack(w, v, W, i - 1, dp);
        else {
            int take = v[i] + zeroOneKnapsack(w, v, W - w[i], i - 1, dp);
            int notTake = zeroOneKnapsack(w, v, W, i - 1, dp);
            return dp[i][W] = Math.max(take, notTake);
        }
    }
}
