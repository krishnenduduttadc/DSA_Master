package DP1;

import java.util.Arrays;

public class KnapsackDuplicate {
    static int knapSack(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[N + 1][W + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return knapsack(wt, val, W, N - 1, dp);
    }

    public static int knapsack(int[] w, int[] v, int k, int i, int[][] dp) {
        if (i < 0 || k == 0)
            return 0;
        if (dp[i][k] != -1)
            return dp[i][k];

        int x = knapsack(w, v, k, i - 1, dp);
        int y = 0;
        if (k >= w[i]) {
            y = knapsack(w, v, k - w[i], i - 1, dp) + v[i];
        }
        dp[i][k] = Math.max(x, y);
        return dp[i][k];
    }

    public static void main(String[] args) {
        // Example test cases
        int N = 4; // Number of items
        int W = 8; // Capacity of knapsack
        int[] val = {1, 4, 5, 7}; // Values of items
        int[] wt = {1, 3, 4, 5}; // Weights of items

        int maxVal = knapSack(N, W, val, wt);
        System.out.println("Maximum value that can be obtained: " + maxVal);
    }
}
