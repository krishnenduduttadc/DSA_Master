/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

import java.util.Vector;

/**
 * @author krish
 */
public class PrintSubsetSum {

    public static void main(String[] args) {
        int arr[] = {15, 20, 12};
        printSubsetsSumTok(arr, 27);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        // Write your code here
        Subsets(input, input.length, k);
    }

    static void Subsets(int arr[], int n, int sum) {
        Vector<Integer> v = new Vector<Integer>();
        Subsets(arr, n, v, sum);
    }

    static void Subsets(int arr[], int n, Vector<Integer> v, int sum) {
        if (sum == 0) {
            for (int i = v.size() - 1; i >= 0; i--) {
                System.out.print(v.get(i) + " ");
            }
            System.out.println();
            return;
        }

        if (n == 0) {
            return;

        }

        Subsets(arr, n - 1, v, sum);
        Vector<Integer> v1 = new Vector<Integer>(v);
        v1.add(arr[n - 1]);
        Subsets(arr, n - 1, v1, sum - arr[n - 1]);
    }

}
