package LeetCodePatterns.DP;

public class UniquePaths {

    // Main method to test the program
    public static void main(String[] args) {
        UniquePaths solver = new UniquePaths();

        int m1 = 3, n1 = 7;
        System.out.println("Unique paths in " + m1 + "x" + n1 + " grid: " + solver.uniquePaths(m1, n1));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        dp[m - 1][n - 1] = 1;

        f(0, 0, m, n, dp);

        return dp[0][0];
    }

    public int f(int i, int j, int m, int n, int[][] dp) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        } else {
            if (dp[i][j] != -1) {
                return dp[i][j];
            } else {
                dp[i][j] = f(i + 1, j, m, n, dp) + f(i, j + 1, m, n, dp);
            }
            return dp[i][j];
        }
    }
}
