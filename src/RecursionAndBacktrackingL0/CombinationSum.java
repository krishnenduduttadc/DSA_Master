package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> comb, int target, int sum, int start) {
        if (sum == target) {
            list.add(new ArrayList<>(comb));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            comb.add(nums[i]);
            dfs(nums, list, comb, target, sum + nums[i], i);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = obj.combinationSum(candidates, target);

        System.out.println("Combination sums for target " + target + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(candidates, list, new ArrayList<>(), target, 0, 0);
        return list;
    }
}
