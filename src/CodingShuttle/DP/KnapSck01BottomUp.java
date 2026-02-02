package CodingShuttle.DP;

public class KnapSck01BottomUp {
    public static void main(String[] args) {

        int[] w = {1, 2, 3};
        int[] v = {30, 40, 60};
        int W = 4;

        System.out.println(zeroOneKnapsackBottomUp(w, v, W));
    }

    static int zeroOneKnapsackBottomUp(int[] w, int[] v, int W) {
        int item = v.length;
        int[][] dp = new int[item + 1][W + 1];
        for (int i = 1; i <= item; i++) {
            for (int curCap = 1; curCap <= W; curCap++) {
                if (w[i - 1] > curCap) { // Can't pick this item
                    dp[i][curCap] = dp[i - 1][curCap];
                } else { // Can pick this item
                    int notTake = dp[i - 1][curCap];
                    int take = v[i - 1] + dp[i - 1][curCap - w[i - 1]];
                    dp[i][curCap] = Math.max(notTake, take);
                }
                System.out.print(dp[i][curCap] + " ");
            }
            System.out.println();
        }
        return dp[item][W];
    }
}
