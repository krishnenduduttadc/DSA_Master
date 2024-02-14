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
public class QuickSort {

    public static void quickSort(int[] input) {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
         */
        quicksort(input, 0, input.length - 1);

    }

    public static void quicksort(int a[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quicksort(a, si, pivotIndex - 1);
        quicksort(a, pivotIndex + 1, ei);

    }

    public static int partition(int a[], int si, int ei) {
        int pivotElement = a[si];
        int smallerNoCnt = 0;

        for (int i = si + 1; i <= ei; i++) {
            if (a[i] < pivotElement) {
                smallerNoCnt++;
            }
        }

        int temp = a[si + smallerNoCnt];
        a[si + smallerNoCnt] = pivotElement;
        a[si] = temp;
        int i = si;
        int j = ei;
        while (i < j) {
            if (a[i] < pivotElement) {
                i++;
            } else if (a[j] >= pivotElement) {
                j--;
            } else {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;

            }
        }
        return si + smallerNoCnt;
    }

    public static void main(String[] args) {
        int[] a=new int[]{5, 6, 4, 3, 7, 2};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
