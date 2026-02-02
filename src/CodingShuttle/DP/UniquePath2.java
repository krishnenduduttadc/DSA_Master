package CodingShuttle.DP;

public class UniquePath2 {
    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(uniquePaths2(a));
    }

    static int uniquePaths2(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        if (a[m - 1][n - 1] == 1) return 0; // if destination is blocked

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;

                if (a[i][j] == 1) dp[i][j] = 0;
                else {
                    int right = (j + 1 < n) ? dp[i][j + 1] : 0;
                    int down = (i + 1 < m) ? dp[i + 1][j] : 0;
                    dp[i][j] = right + down;
                }
            }
        }

        return dp[0][0];
    }
}
