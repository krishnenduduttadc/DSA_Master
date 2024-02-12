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
public class IndexofFirstOccurance {

    public static void main(String[] args) {
        System.out.println(searchR(new int[]{3, 5, 8, 8, 9, 9}, 0, 5, 8));
        
        System.out.println(searchI(new int[]{3, 5, 8, 8, 9, 9}, 8));
    }

    private static int searchR(int[] arr, int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] > x) {
            return searchR(arr, low, mid - 1, x);
        } else if (arr[mid] < x) {
            return searchR(arr, mid + 1, high, x);
        } else {
            if (arr[mid - 1] != arr[mid] || mid == 0) {
                return mid;
            } else {
                return searchR(arr, low, mid - 1, x);
            }
        }
    }

    private static int searchI(int[] arr, int x) {
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
}
