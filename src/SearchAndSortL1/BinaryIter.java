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
public class BinaryIter {

    public static void main(String[] args) {
        System.out.println(binsearch(new int[]{3, 5, 7, 8, 9}, 8));
    }

    static int binsearch(int[] arr, int x) {
        int low, high, mid;
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            else if ( arr[mid] >x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
