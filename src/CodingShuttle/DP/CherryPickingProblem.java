package CodingShuttle.DP;

public class CherryPickingProblem {
    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1}
        };
        System.out.println(cherryPicking(a));
    }

    static int cherryPicking(int[][] a) {
        int n = a.length;
        Integer[][][][] dp = new Integer[n][n][n][n];
        return Math.max(0, cherryPickingUtil(a, 0, 0, 0, 0, dp));
    }

    static int cherryPickingUtil(int[][] a, int r1, int c1, int r2, int c2, Integer[][][][] dp) {
        int n = a.length;
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || a[r1][c1] == -1 || a[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) { //p1 has reached dest
            return a[r1][c1];
        }
        if (r2 == n - 1 && c2 == n - 1) { //p2 has reached dest
            return a[r2][c2];
        }

        if (dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];

        int cherries = 0;
        if (r1 == r2 && c1 == c2) { //both are at same cell
            cherries = a[r1][c1];
        } else {
            cherries = a[r1][c1] + a[r2][c2];
        }
        // RR // RD // DR // DD

        cherries += Math.max(Math.max(cherryPickingUtil(a, r1 + 1, c1, r2 + 1, c2, dp),
                        cherryPickingUtil(a, r1 + 1, c1, r2, c2 + 1, dp)),
                Math.max(cherryPickingUtil(a, r1, c1 + 1, r2 + 1, c2, dp),
                        cherryPickingUtil(a, r1, c1 + 1, r2, c2 + 1, dp)));

        return dp[r1][c1][r2][c2] = cherries;
    }
}
