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
public class CoinChangePermutation {
    public static void main(String[] args) {
        int arr[] = {2, 3, 5,6};
        int tar = 10;
        int[] dp=new int[tar+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]<=i){
                    dp[i]=dp[i]+dp[i-arr[j]];
                }
            }
        }       
        System.out.println(""+dp[tar]);
    }
}
