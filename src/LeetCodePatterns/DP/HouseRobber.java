package LeetCodePatterns.DP;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber solver = new HouseRobber();

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        int[] nums3 = {5};

        System.out.println("Max rob [1,2,3,1]: " + solver.rob(nums1)); // 4
        System.out.println("Max rob [2,7,9,3,1]: " + solver.rob(nums2)); // 12
        System.out.println("Max rob [5]: " + solver.rob(nums3)); // 5
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
