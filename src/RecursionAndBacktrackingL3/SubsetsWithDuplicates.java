package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {


    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>());
    }

    public static void backtrack(int[] nums, int index, List<Integer> current) {

        System.out.println(current);

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]);

            backtrack(nums, i + 1, current);

            current.remove(current.size() - 1);
        }
    }

}
