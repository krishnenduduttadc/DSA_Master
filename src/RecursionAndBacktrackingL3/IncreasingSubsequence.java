package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence {


    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        backtrack(nums, 0, new ArrayList<>());
    }

    public static void backtrack(int[] nums, int index, List<Integer> current) {

        if (current.size() >= 2)
            System.out.println(current);

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (used.contains(nums[i]))
                continue;

            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {

                used.add(nums[i]);
                current.add(nums[i]);

                backtrack(nums, i + 1, current);

                current.remove(current.size() - 1);
            }
        }
    }

}
