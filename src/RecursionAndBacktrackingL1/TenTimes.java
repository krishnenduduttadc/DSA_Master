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
public class TenTimes {

    public static void main(String[] args) {
        int arr[] = {1, 3, 20};
        System.out.println("" + array220(arr, 0));
    }

    public static boolean array220(int[] nums, int index) {

        if (index >= nums.length - 1) {
            return false;
        }
        if (nums.length == 0) {
            return true;
        }
        if (nums[index] * 10 == nums[index + 1]) {
            return true;
        } else {
            boolean small = array220(nums, index + 1);

            return small;
        }

    }
}
