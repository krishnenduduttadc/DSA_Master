package LeetCodePatterns.DP;

public class LIS {
    public static void main(String[] args) {
        LIS solver = new LIS();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7};

        System.out.println("LIS of [10,9,2,5,3,7,101,18]: " + solver.lengthOfLIS(nums1)); // 4
        System.out.println("LIS of [0,1,0,3,2,3]: " + solver.lengthOfLIS(nums2)); // 4
        System.out.println("LIS of [7,7,7,7,7]: " + solver.lengthOfLIS(nums3)); // 1
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        int ans = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
