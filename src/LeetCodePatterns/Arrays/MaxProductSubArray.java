package LeetCodePatterns.Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        MaxProductSubArray solution = new MaxProductSubArray();

        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 = {-2, 3, -4};

        System.out.println("Max product of nums1: " + solution.maxProduct(nums1)); // Expected: 6
        System.out.println("Max product of nums2: " + solution.maxProduct(nums2)); // Expected: 0
        System.out.println("Max product of nums3: " + solution.maxProduct(nums3)); // Expected: 24
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxProduct = Math.max(nums[i], maxProduct * nums[i]);
                minProduct = Math.min(nums[i], minProduct * nums[i]);
            } else {
                int temp = maxProduct;
                maxProduct = Math.max(nums[i], minProduct * nums[i]);
                minProduct = Math.min(nums[i], temp * nums[i]);
            }

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
