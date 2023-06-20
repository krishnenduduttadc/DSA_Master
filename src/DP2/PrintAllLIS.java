/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP2;

import java.util.ArrayDeque;

/**
 *
 * @author krish
 */
public class PrintAllLIS {

    public static class Pair {

        int l, i, val;
        String psf;

        Pair(int l, int i, int val, String psf) {
            this.l = l;
            this.i = i;
            this.val = val;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 3};
        solution(arr);
    }

    private static void solution(int[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;
        int omi = 0;
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
                omi = i;
            }

        }
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(omax, omi, arr[omi], arr[omi] + ""));
        while (q.size() > 0) {
            Pair rem = q.removeFirst();
            if (rem.l == 1) {
                System.out.println(rem.psf);
            }
            for (int j = 0; j < rem.i; j++) {
                if (dp[j] == rem.l - 1 && arr[j] <= rem.val) {
                    q.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
    }
}
