package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.List;

public class SubsetUnique {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }

    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> sub, int start) {
        list.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            dfs(nums, list, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<>(), 0);
        return list;
    }
}
