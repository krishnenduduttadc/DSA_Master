package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> comb, int targetSum, int currSum, int start) {
        if (currSum == targetSum) {
            list.add(new ArrayList<>(comb));
            return;
        } else if (currSum > targetSum) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            comb.add(nums[i]);
            dfs(nums, list, comb, targetSum, currSum + nums[i], i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = obj.combinationSum2(candidates, target);

        System.out.println("Unique combinations summing to " + target + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, list, new ArrayList<>(), target, 0, 0);
        return list;
    }
}
