/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL1;

/**
 *
 * @author krish
 */
public class Goldmine {
    //        int grid[][] = {
//            {1, 0, 7},
//            {2, 0, 6},
//            {3, 4, 5},
//            {0, 3, 0},
//            {9, 0, 20}};

    public static void main(String[] args) {
        int grid[][] = {
            {8, 2, 1, 6},
            {6, 5, 5, 2},
            {2, 1, 0, 3},
            {7, 2, 2, 4}
        };

        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int j = grid[0].length - 1; j >= 0; j--) {
            for (int i = grid.length - 1; i >= 0; i--) {
                if (j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == grid.length - 1) {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }

        }
        System.out.println("" + max);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(" " + dp[i][j]);
//            }
//            System.out.println("");
//        }
    }
}
