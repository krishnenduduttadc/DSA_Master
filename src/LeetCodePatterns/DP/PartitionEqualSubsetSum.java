package LeetCodePatterns.DP;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum solver = new PartitionEqualSubsetSum();

        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};

        System.out.println("Can partition [1,5,11,5]: " + solver.canPartition(nums1)); // true
        System.out.println("Can partition [1,2,3,5]: " + solver.canPartition(nums2)); // false
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return dfs(0, target, nums, dp);
    }

    private boolean dfs(int i, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == nums.length || target < 0) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean take = dfs(i + 1, target - nums[i], nums, dp);
        boolean skip = dfs(i + 1, target, nums, dp);

        dp[i][target] = take || skip;
        return dp[i][target];
    }
}
