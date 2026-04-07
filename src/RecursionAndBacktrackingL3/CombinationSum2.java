package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {


    public static void main(String[] args) {

        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>());
    }

    public static void backtrack(int[] nums, int target, int index, List<Integer> current) {

        if (target == 0) {
            System.out.println(current);
            return;
        }

        if (target < 0)
            return;

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]);

            backtrack(nums, target - nums[i], i + 1, current);

            current.remove(current.size() - 1);
        }
    }

}
