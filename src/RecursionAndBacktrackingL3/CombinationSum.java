package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<Integer> current = new ArrayList<>();
        backtrack(nums, target, 0, current);
    }

    public static void backtrack(int[] nums, int target, int index, List<Integer> current) {

        if (target == 0) {
            System.out.println(current);
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // Choose
            current.add(nums[i]);
            // Explore (notice i, not i+1 because reuse allowed)
            backtrack(nums, target - nums[i], i, current);
            // Un-choose
            current.remove(current.size() - 1);
        }
    }

}
