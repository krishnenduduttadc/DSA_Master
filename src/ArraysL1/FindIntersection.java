/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

import java.util.Arrays;

/**
 * @author krish
 */
class FindIntersection {

    static void printIntersection(int arr1[], int arr2[], int m, int n) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }

    public static void main(String args[]) {
        int arr1[] = {2, 6, 8, 5, 4, 3};
        int arr2[] = {2, 3, 4, 7};
        int n = arr1.length;
        int m = arr2.length;
        printIntersection(arr1, arr2, n, m);
    }
}