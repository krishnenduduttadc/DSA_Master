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
public class PerfectSquares {
    public static void main(String[] args) {
        int n=10;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int rem=i- j*j;
                if(dp[rem]<min){
                    min=dp[rem];
                }
            }
            dp[i]=min+1;
        }
        return dp[n];
    }
    
}
