package DynamicProgrammingL1;

public class MinCostPath {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int grid[][] = {
                {8, 2, 1, 6},
                {6, 5, 5, 2},
                {2, 1, 0, 3},
                {7, 2, 2, 4}

        };
        int dp[][] = new int[n][m];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i==grid.length-1 && j==grid[0].length-1) {
                    dp[i][j] = grid[i][j];
                } else if (i== grid.length-1) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else if (j==grid[0].length-1) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] +Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
