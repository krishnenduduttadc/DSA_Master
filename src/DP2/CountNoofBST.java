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
public class CountNoofBST {
    public static void main(String[] args) {
        int n=4;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for (int i = 2; i <=n; i++) {
            int l=0;
            int r=i-1;
            while(l<=i-1){
                dp[i]+=dp[l]*dp[r];
                l++;
                r--;
            }
        }
        
        System.out.println(dp[n]);
    }
            
}
