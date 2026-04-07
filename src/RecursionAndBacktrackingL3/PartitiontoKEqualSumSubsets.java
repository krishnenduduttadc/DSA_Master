package RecursionAndBacktrackingL3;

public class PartitiontoKEqualSumSubsets {


    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        System.out.println(canPartition(nums, k));
    }

    public static boolean canPartition(int[] nums, int k) {

        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % k != 0)
            return false;

        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, k, 0, 0, sum / k);
    }

    public static boolean backtrack(int[] nums, boolean[] used, int k, int start, int currSum, int target) {

        if (k == 1)
            return true;

        if (currSum == target)
            return backtrack(nums, used, k - 1, 0, 0, target);

        for (int i = start; i < nums.length; i++) {

            if (used[i]) continue;

            used[i] = true;

            if (backtrack(nums, used, k, i + 1, currSum + nums[i], target))
                return true;

            used[i] = false;
        }
        return false;
    }

}
