package DPL1;

import java.util.Arrays;

public class Sticklertheif {
    public int FindMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSubSeq(arr, n - 1, dp);
    }

    public int maxSubSeq(int[] arr, int i, int[] dp) {
        if (i < 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int x = maxSubSeq(arr, i - 1, dp);
        int y = maxSubSeq(arr, i - 2, dp) + arr[i];
        dp[i] = Math.max(x, y);
        return Math.max(x, y);
    }

    public static void main(String[] args) {
        Sticklertheif solution = new Sticklertheif();

        // Test cases
        int[][] testCases = {
                {6, 7, 1, 30, 8, 2, 4},
                {20, 5, 1, 13, 6, 11, 40},
                {5, 5, 10, 100, 10, 5},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int[] arr : testCases) {
            int n = arr.length;
            int maxSum = solution.FindMaxSum(arr, n);
            System.out.println("Array: " + Arrays.toString(arr));
            System.out.println("Maximum money the thief can get: " + maxSum);
            System.out.println();
        }
    }
}
