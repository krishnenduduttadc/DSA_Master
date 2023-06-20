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
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "baaabab";
        String s2 = "baaab";
        System.out.println(sol(s1,s2));
    }

    private static int sol(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        int max=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                char c1=s1.charAt(i-1);
                char c2=s2.charAt(j-1);
                if(c1!=c2){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                if(dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        return max;
    }
}
