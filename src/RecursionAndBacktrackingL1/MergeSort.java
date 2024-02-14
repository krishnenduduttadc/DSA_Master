/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krish
 */
public class MergeSort {

    public static void mergeSort(int[] input) {
        // Write your code here
        mergeSort(input, 0, input.length - 1);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, end);  
    }

    private static void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        int x = 0;
        for (int m = start; m <= end; m++) {
            arr[m] = temp[x++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 6, 4, 3, 7, 2};
        mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
