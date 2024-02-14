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
public class PrintSubsets {

    public static void main(String[] args) {
        int arr[] = {15, 20, 12};
        printSubsets(arr);
    }

    public static void printSubsets(int input[]) {
        printSubsets(input, 0, input.length - 1, new int[0]);
    }

    public static void printSubsets(int[] arr, int start, int end, int[] output) {
        if (start > end) {
            for (int x : output) {
                System.out.print(x + " ");
            }
            System.out.println("");
            return;
        }

        int[] temp = new int[output.length + 1];

        for (int i = 0; i < output.length; i++) {
            temp[i] = output[i];
        }
        temp[temp.length - 1] = arr[start];
        printSubsets(arr, start + 1, end, temp);
        printSubsets(arr, start + 1, end, output);
    }
}
