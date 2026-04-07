package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.List;

public class Permutation {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, current);
    }

    public static void backtrack(int[] nums, boolean[] used, List<Integer> current) {

        // Base case
        if (current.size() == nums.length) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, used, current);

            // Un-choose
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

}
