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
public class CheckarrSorted {

    static boolean sorted(int arr[], int n) {
        if (n == 1 || n == 0) {
            return true;
        } else if (arr[n - 1] < arr[n - 2]) {
            return false;
        } else {
            return sorted(arr, n - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println("" + sorted(arr, arr.length));
    }
}
