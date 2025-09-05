package LeetCodePatterns.Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        ProductOfArrayExceptItself solution = new ProductOfArrayExceptItself();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};

        System.out.println("Output for nums1: " + Arrays.toString(solution.productExceptSelf(nums1)));
        // Expected: [24, 12, 8, 6]

        System.out.println("Output for nums2: " + Arrays.toString(solution.productExceptSelf(nums2)));
        // Expected: [0, 0, 9, 0, 0]
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int[] output = new int[nums.length];

        int n = nums.length;

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}
