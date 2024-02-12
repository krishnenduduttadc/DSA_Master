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
public class CountOnes {
    public static void main(String[] args) {
        System.out.println(cntones(new int[]{0,0,0,1,1,1,1,1}));
    }

    private static int cntones(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] ==0) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid-1] ==0) {
                    return arr.length-mid;
                } else {
                    high=mid-1;
                }
            }
        }
        return 0;
    }
}
