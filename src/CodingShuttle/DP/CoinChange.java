package CodingShuttle.DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] a = {1, 5, 8};
        int sum = 19;

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);

        System.out.println(countMinCoins(a, sum, dp));
        System.out.println(countMinCoinsBottomUp(a, sum));
    }

    static int countMinCoins(int[] a, int sum, int[] dp) {
        if (sum == 0) return 0;
        if (sum < 0) return Integer.MAX_VALUE;

        if (dp[sum] != -1) return dp[sum];

        int min = Integer.MAX_VALUE;
        for (int coin : a) {
            int count = countMinCoins(a, sum - coin, dp);
            if (count < min) {
                min = count;
            }
        }
        return dp[sum] = min + 1;
    }

    static int countMinCoinsBottomUp(int[] a, int sum) {
        int[] dp = new int[sum + 1];

        for (int i = 1; i <= sum; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : a) {
                if (coin <= i) {
                    min = Math.min(min, 1 + dp[i - coin]);
                }
            }
            dp[i] = min;
        }

        for (int i = 0; i <= sum; i++) {
            System.out.println(i + " -> " + dp[i]);
        }

        return dp[sum];
    }
}
