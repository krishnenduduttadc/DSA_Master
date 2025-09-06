package LeetCodePatterns.DP;

public class MinCostClimbingStairs {

    // Main method to test the program
    public static void main(String[] args) {
        MinCostClimbingStairs solver = new MinCostClimbingStairs();

        int[] cost1 = {10, 15, 20};
        System.out.println("Minimum cost (example 1): " + solver.minCostClimbingStairs(cost1));

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost (example 2): " + solver.minCostClimbingStairs(cost2));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0;

        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = Math.min(dp[1] + cost[i - 1], dp[0] + cost[i - 2]);
            dp[0] = dp[1];
            dp[1] = result;
        }

        return result;
    }
}
