package LeetCodePatterns.RandB;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets;
    public int[] nums;

    public static void main(String[] args) {
        Subsets solver = new Subsets();

        int[] nums1 = {1, 2, 3};
        System.out.println("Subsets of [1, 2, 3]: " + solver.subsets(nums1));
        // Expected: [[], [3], [2], [2,3], [1], [1,3], [1,2], [1,2,3]]
    }

    public List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<>();
        this.nums = nums;

        List<Integer> subset = new ArrayList<>();
        backtrack(0, subset);
        return this.subsets;
    }

    public void backtrack(int i, List<Integer> subset) {
        if (i >= nums.length) {
            List<Integer> ans = new ArrayList<>();
            for (int num : subset) {
                ans.add(num);
            }
            subsets.add(ans);
        } else {
            backtrack(i + 1, subset);
            subset.add(nums[i]);
            backtrack(i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
