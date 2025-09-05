package LeetCodePatterns.Arrays;

public class MaxSumArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int x = maxSubArr(nums);
        System.out.println(x);
    }

    static int maxSubArr(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += nums[i];

            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }
        }
        return maxSoFar;
    }
}
