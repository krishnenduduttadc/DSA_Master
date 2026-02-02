package CodingShuttle.DP;

import java.util.Arrays;

public class BurstBaloon {

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        System.out.println(balloonBursting(a));
        System.out.println(balloonBurstingBottomUp(a));
    }

    static int balloonBurstingBottomUp(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] b = new int[n + 2];
        b[0] = b[n + 1] = 1;
        System.arraycopy(a, 0, b, 1, n);

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int profitByInflatingK = b[k] * b[i - 1] * b[j + 1] +
                            dp[i][k - 1] +
                            dp[k + 1][j];
                    max = Math.max(max, profitByInflatingK);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    static int balloonBursting(int[] a) {
        int n = a.length;
        int[] b = new int[n + 2];
        b[0] = b[n + 1] = 1;
        System.arraycopy(a, 0, b, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] e : dp) Arrays.fill(e, -1);
        return balloonBursting(b, 1, n, dp);
    }


    static int balloonBursting(int[] a, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int profitByInflatingK = a[k] * a[i - 1] * a[j + 1] +
                    balloonBursting(a, i, k - 1, dp) +
                    balloonBursting(a, k + 1, j, dp);
            max = Math.max(max, profitByInflatingK);
        }
        return dp[i][j] = max;
    }
}
