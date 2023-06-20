/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP2;

import java.util.HashMap;

/**
 *
 * @author krish
 */
public class CountDistinctSubseq {

    public static void main(String[] args) {
        String str = "abcbac";
        int[] dp = new int[str.length()+1];
        dp[0] = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1];
            char ch = str.charAt(i - 1);
            if (hm.containsKey(ch)) {
                int j = hm.get(ch);
                dp[i] = dp[i] - dp[j - 1];
            }
            hm.put(ch, i);
        }

        System.out.println(dp[str.length()] - 1);
    }
}
