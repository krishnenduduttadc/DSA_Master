package LeetCodePatterns.DP;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs solver = new ClimbingStairs();

        int n1 = 2;
        int n2 = 3;
        int n3 = 5;

        System.out.println("Ways to climb " + n1 + " stairs: " + solver.climbStairs(n1)); // 2
        System.out.println("Ways to climb " + n2 + " stairs: " + solver.climbStairs(n2)); // 3
        System.out.println("Ways to climb " + n3 + " stairs: " + solver.climbStairs(n3)); // 8
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }
}
