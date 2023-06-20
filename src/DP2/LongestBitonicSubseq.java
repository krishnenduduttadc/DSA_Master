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
public class LongestBitonicSubseq {

    public static void main(String[] args) {

        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        int n = arr.length;
        int lis[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (lis[j] > max) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = max + 1;
        }

        ///////////////
        int lds[] = new int[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] <= arr[i]) {
                    if (lds[j] > max) {
                        max = lds[j];
                    }
                }
            }
            lds[i] = max + 1;
        }

        int omax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }
        }

        System.out.println("" + omax);
    }
}
