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
public class KadaneMaximumSumSubarray {

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 4, 3, 6, 4};
        System.out.println(sol(arr));
    }

    private static int sol(int[] arr) {
        int csum = arr[0];
        int osum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (csum >= 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }

            if (csum > osum) {
                osum = csum;
            }
        }
        return osum;
    }

}
