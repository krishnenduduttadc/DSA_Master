package LeetCodePatterns.Arrays;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();

        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        int[] nums3 = {0, 0, 0, 0};
        int[] nums4 = {1, 1, 1, 1};

        System.out.println("Max consecutive ones in nums1: " + solution.findMaxConsecutiveOnes(nums1)); // Expected: 3
        System.out.println("Max consecutive ones in nums2: " + solution.findMaxConsecutiveOnes(nums2)); // Expected: 2
        System.out.println("Max consecutive ones in nums3: " + solution.findMaxConsecutiveOnes(nums3)); // Expected: 0
        System.out.println("Max consecutive ones in nums4: " + solution.findMaxConsecutiveOnes(nums4)); // Expected: 4
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++;
            }
            if (count > ans) {
                ans = count;
            }
        }

        return ans;
    }
}
