package RecursionAndBacktrackingL3;

import java.util.Arrays;

public class MatchsticksToSquare {


    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 2};
        System.out.println(canMakeSquare(nums));
    }

    public static boolean canMakeSquare(int[] nums) {

        int sum = 0;
        for (int n : nums) sum += n;

        if (sum % 4 != 0) return false;

        Arrays.sort(nums);
        int[] sides = new int[4];

        return backtrack(nums, nums.length - 1, sides, sum / 4);
    }

    public static boolean backtrack(int[] nums, int index,
                                    int[] sides, int target) {

        if (index < 0)
            return true;

        for (int i = 0; i < 4; i++) {

            if (sides[i] + nums[index] > target)
                continue;

            sides[i] += nums[index];

            if (backtrack(nums, index - 1, sides, target))
                return true;

            sides[i] -= nums[index];
        }
        return false;
    }

}
