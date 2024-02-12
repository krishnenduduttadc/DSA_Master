/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

/**
 *
 * @author krish
 */
public class Test {

    public static void main(String[] args) {
        int[] nums1 = {1, 4};
        int[] nums2 = {2, 3, 6, 7, 8};
        merge(nums1, 2, nums2, 5);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int arr[] = new int[m + n];
        for (; i < m && j < n;) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                k++;
                i++;
            } else {
                arr[k] = nums2[j];
                k++;
                j++;
            }
        }

        while (i < m) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        for (int l = 0; l < arr.length; l++) {

            System.out.print(" " + arr[l]);

        }
    }
}
