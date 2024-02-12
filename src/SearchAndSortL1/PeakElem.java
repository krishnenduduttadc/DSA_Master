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
public class PeakElem {

    public static void main(String[] args) {
        System.out.println(peakelem(new int[]{10, 7, 8, 20, 12}));
    }

    private static int peakelem(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid])
                    && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            }
            if (mid > 0 && arr[mid - 1] >= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
