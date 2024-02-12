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
public class SubsetSum {

    static int subsets(int arr[], int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return subsets(arr, n - 1, sum) + subsets(arr, n - 1, sum - arr[n - 1]);

    }

    public static void main(String a[]) {
        System.out.println("" + subsets(new int[]{10, 20, 25}, 3, 25));
    }
}
