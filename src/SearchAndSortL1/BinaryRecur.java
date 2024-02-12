/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSortL1;

/**
 *
 * @author krish
 */
public class BinaryRecur {

    public static void main(String[] args) {
        System.out.println(binsearch(new int[]{3, 5, 7, 8, 9, 11, 45, 76}, 0, 7, 11));
    }

    private static int binsearch(int[] arr, int low, int high, int x) {

        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] > x) {
            return binsearch(arr, low, mid - 1, x);
        } else {
            return binsearch(arr, mid + 1, high, x);
        }
    }
}
