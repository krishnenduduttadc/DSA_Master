/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;

/**
 *
 * @author krish
 */
public class CountPalindromicSubsequences {

    public static void main(String[] args) {
        String str = "abccbc";
        int[][] dp = new int[str.length()][str.length()];
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[0][str.length() - 1]);
    }
}
