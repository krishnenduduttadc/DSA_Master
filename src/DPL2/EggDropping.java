/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;


public class EggDropping {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(eggdrop(n, k));
    }

    public static int eggdrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
                        int v1 = dp[i][mj];//egg survices
                        int v2 = dp[i - 1][pj];//egg breaks
                        int val = Math.max(v1, v2);
                        min = Math.min(val, min);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[n][k];
    }
}
