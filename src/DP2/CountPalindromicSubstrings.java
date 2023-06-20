/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP2;

/**
 *
 * @author krish
 */
public class CountPalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abccbc";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int cnt = 0;
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        System.out.println("" + cnt);
    }
}
