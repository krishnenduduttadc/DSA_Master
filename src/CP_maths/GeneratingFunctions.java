package CP_maths;


class GeneratingFunctions {
    /*
    ===============================================================
        Generating Functions (CP Applications)
    ===============================================================

    Idea:
      Encode counting problem as polynomial product.
      Coefficients = number of ways.

    Example 1: Coin Change with coins {1,2,3}
      G(x) = (1 + x + x^2 + ...) * (1 + x^2 + x^4 + ...) * (1 + x^3 + x^6 + ...)
      Coeff of x^n = #ways to form n

    In CP → implemented as DP.
    ===============================================================
    */

    // Coin change DP: number of ways to form sum n using given coins
    static int coinChange(int[] coins, int n) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        System.out.println("Ways to make 5 with {1,2,3}: " + coinChange(coins, 5));
        // Expected: 5
        // (11111, 113, 122, 23, 5x1+1x2)
    }
}

