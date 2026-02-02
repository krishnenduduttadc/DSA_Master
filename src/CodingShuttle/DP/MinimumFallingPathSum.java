package CodingShuttle.DP;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] a = {
                {20, 10, 3},
                {6, 5, 4},
                {-70, -1, 1}
        };
        System.out.println(minFallingPathSum(a));
    }

    static int minFallingPathSum(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        int[] dp1 = new int[col + 2];
        int[] dp2 = new int[col + 2];

        dp1[0] = Integer.MAX_VALUE;
        dp1[col + 1] = Integer.MAX_VALUE;

        System.arraycopy(a[row - 1], 0, dp1, 1, col);

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 1; j <= col; j++) {
                int min = Math.min(dp1[j - 1], Math.min(dp1[j], dp1[j + 1]));
                dp2[j] = min + a[i][j - 1];
            }
            System.arraycopy(dp2, 1, dp1, 1, col);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= col; i++) min = Math.min(min, dp2[i]);
        return min;
    }
}
