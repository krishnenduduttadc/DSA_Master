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
public class CountOccurance {

    public static void main(String[] args) {
        System.out.println(cntOccur(new int[]{3, 7, 7, 7, 9}, 7));
    }

    private static int searchFirst(int[] arr, int x) {
        int low, high, mid;
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                if (arr[mid - 1] != arr[mid] || mid == 0) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int serchLast(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private static int cntOccur(int[] arr, int x) {
        int first = searchFirst(arr, x);
        if (first == -1) {
            return 0;
        } else {
            return (serchLast(arr, x) - first + 1);
        }
    }
}
