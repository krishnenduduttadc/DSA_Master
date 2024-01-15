/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML2;

import java.util.HashSet;


public class LengthofLargestSubarraywithContiguousElements {

    public static void main(String[] args) {
        int arr[] = {9, 2, 1, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0};
        System.out.println("" + sol(arr));
    }

    static int sol(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int max = arr[i];
            HashSet<Integer> cd = new HashSet<>();
            cd.add(arr[i]);

            for (int j = i + 1; j < arr.length; j++) {
                if (cd.contains(arr[j])) {
                    break;
                }
                cd.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if (max - min == j - i) {
                    int len = j - i + 1;
                    if (len > ans) {
                        ans = len;
                    }
                }
            }
        }
        return ans;
    }
}
