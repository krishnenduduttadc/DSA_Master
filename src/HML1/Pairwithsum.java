/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML1;

import java.util.HashSet;

/**
 *
 * @author krish
 */
public class Pairwithsum {

    static int pairWithSumX(int arr[], int n, int X) {
        HashSet<Integer> us = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (us.contains(X - arr[i])) {
                return 1;
            }

            us.add(arr[i]);
        }
        return 0;

    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 8, 4, 7, 6, 1};
        int len = arr.length;
        int x = 14;
        System.out.println(pairWithSumX(arr, len, x));
    }

}
