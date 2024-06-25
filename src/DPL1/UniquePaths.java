package DPL1;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }  else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();

        // Test cases
        int[][] testCases = {
                {3, 2}, // m = 3, n = 2
                {7, 3}, // m = 7, n = 3
                {3, 3}, // m = 3, n = 3
                {1, 1}  // m = 1, n = 1
        };

        for (int[] testCase : testCases) {
            int m = testCase[0];
            int n = testCase[1];
            int uniquePaths = solution.uniquePaths(m, n);
            System.out.printf("For m = %d, n = %d, unique paths = %d\n", m, n, uniquePaths);
        }
    }
}
