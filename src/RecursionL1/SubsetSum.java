/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionL1;

/**
 *
 * @author krish
 */
public class SubsetSum {

    static void subsetSums(int[] arr, int l,
            int r, int sum) {
        if (l > r) {
            System.out.print(sum + " ");
            return;
        }
        subsetSums(arr, l + 1, r, sum + arr[l]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 5, 4};
        int n = arr.length;

        subsetSums(arr, 0, n - 1, 0);
    }
}
