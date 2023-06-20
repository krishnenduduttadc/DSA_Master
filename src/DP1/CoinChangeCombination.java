/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP1;

/**
 *
 * @author krish
 */
public class CoinChangeCombination {

    public static void main(String[] args) {
        int arr[] = {2, 3, 5};
        int amt = 10;
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - arr[i]];
            }
        }
        System.out.println("" + dp[amt]);
    }
}
