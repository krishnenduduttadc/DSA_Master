package LeetCodePatterns.RandB;

import java.util.*;

public class Subsets2 {
    public static void main(String[] args) {
        Subsets2 solver = new Subsets2();
        int[] nums1 = {1, 2, 2};
        System.out.println("Subsets of [1,2,2]: " + solver.subsetsWithDup(nums1));
        // Expected: [[], [1], [2], [1,2], [2,2], [1,2,2]]
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();

        Arrays.sort(nums);
        backtrack(subsets, new ArrayList<>(), nums, 0);

        return new ArrayList<>(subsets);

    }

    public void backtrack(Set<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int i) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(currentSubset));
        } else {
            currentSubset.add(nums[i]);
            backtrack(subsets, currentSubset, nums, i + 1);
            currentSubset.remove(currentSubset.size() - 1);

            backtrack(subsets, currentSubset, nums, i + 1);
        }
    }
}
