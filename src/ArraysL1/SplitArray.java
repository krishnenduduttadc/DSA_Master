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
public class SplitArray {

    public static boolean spiltArray(int[] input) {
        return splitArray(input, 0, input.length - 1, 0, 0);
    }

    public static boolean splitArray(int[] arr, int start, int end, int lSum, int rSum) {

        if (start > end) {
            return lSum == rSum;
        }
        if (arr[start] % 5 == 0) {
            return splitArray(arr, start + 1, end, lSum + arr[start], rSum);
        } else if (arr[start] % 3 == 0) {
            return splitArray(arr, start + 1, end, lSum, rSum + arr[start]);
        } else {
            return splitArray(arr, start + 1, end, lSum + arr[start], rSum) || splitArray(arr, start + 1, end, lSum, rSum + arr[start]);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 4};
        System.out.println(spiltArray(arr));
    }
}
