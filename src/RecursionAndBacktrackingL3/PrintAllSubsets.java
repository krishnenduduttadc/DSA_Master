package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, current);
    }

    public static void backtrack(int[] nums, int index, List<Integer> current) {

        // Print current subset
        System.out.println(current);

        // Try all possibilities
        for (int i = index; i < nums.length; i++) {

            // 1️⃣ Choose
            current.add(nums[i]);

            // 2️⃣ Explore
            backtrack(nums, i + 1, current);

            // 3️⃣ Un-choose (Backtrack)
            current.remove(current.size() - 1);
        }
    }

}
