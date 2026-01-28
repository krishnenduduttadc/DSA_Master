/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;


public class BurstBaloons {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        System.out.println(sol(arr));
    }

    private static int sol(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : arr[i - 1]) * arr[k] * (j == arr.length - 1 ? 1 : arr[j + 1]);
                    int total = left + right + val;
                    if (total > max) {
                        max = total;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][dp.length - 1];
    }
}
