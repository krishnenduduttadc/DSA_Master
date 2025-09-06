package LeetCodePatterns.BitManipulation;

public class MissingNumber {
    // Main method to test the program
    public static void main(String[] args) {
        MissingNumber solver = new MissingNumber();

        int[] nums1 = {3, 0, 1};
        System.out.println("Missing number in [3,0,1]: " + solver.missingNumber(nums1)); // Expected 2

        int[] nums2 = {0, 1};
        System.out.println("Missing number in [0,1]: " + solver.missingNumber(nums2)); // Expected 2

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number in [9,6,4,2,3,5,7,0,1]: " + solver.missingNumber(nums3)); // Expected 8

        int[] nums4 = {0};
        System.out.println("Missing number in [0]: " + solver.missingNumber(nums4)); // Expected 1
    }

    public int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i <= nums.length; i++) {
            x = x ^ i;
        }

        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            y = y ^ nums[i];
        }

        return x ^ y;
    }
}
