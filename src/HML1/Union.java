/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author krish
 */
public class Union {

    static int unionSize(int arr1[], int m, int arr2[], int n) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < n; i++) {
            hs.add(arr2[i]);
        }

        return hs.size();
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{2, 8, 3, 5, 6};
        int arr2[] = new int[]{4, 8, 3, 6, 1};
        int m = arr1.length;
        int n = arr2.length;

        System.out.println(unionSize(arr1, m, arr2, n));
    }

}
