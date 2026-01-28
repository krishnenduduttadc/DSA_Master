/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;


public class MaxSumIncreasingSubseq {

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        int omax = Integer.MIN_VALUE;
        int dp[] = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            Integer max = null;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {

                    if (max == null) {
                        max = dp[j];
                    } else if (dp[j] > max) {
                        max = dp[j];
                    }
                }

            }

            if (max == null) {
                dp[i] = arr[i];
            } else {
                dp[i] = max + arr[i];
            }
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }

        System.out.println(
                "" + omax);
    }
}
