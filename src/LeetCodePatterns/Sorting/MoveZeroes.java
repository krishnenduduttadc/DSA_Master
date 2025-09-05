package LeetCodePatterns.Sorting;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1)); // Expected: [1, 3, 12, 0, 0]
    }

    public void moveZeroes(int[] nums) {
        int i = nums.length;
        for (int ind = 0; ind < nums.length; ind++) {
            if (nums[ind] == 0) {
                i = ind;
                break;
            }

        }

        int j = i + 1;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }

    }
}
