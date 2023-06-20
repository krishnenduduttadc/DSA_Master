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
public class MaximumSumSubarrayWithAtLeastSizeK {

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 4, 3, 6, 4};
        int k = 4;
        System.out.println(sol(arr, k));
    }

    private static int sol(int[] arr, int k) {
        int ans = 0;
        int csum = arr[0];
        int[] maxsum = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            if (csum > 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }
            maxsum[i] = csum;
        }
        
        int exactK=0;
        for(int i=0;i<k;i++){
            exactK+=arr[i];
        }
        if(exactK>ans){
            ans=exactK;
        }
        
        for(int i=k;i<arr.length;i++){
            exactK=exactK+arr[i]-arr[i-k];
            if(exactK>ans){
                ans=exactK;
            }
            int morethanK=maxsum[i-k]+exactK;
            if(morethanK>ans){
                ans=morethanK;
            }
        }
        return ans;
    }

}
