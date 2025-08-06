package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void dfs(List<List<Integer>> list, List<Integer> comb, int targetSum, int size, int start, int currSum) {
        if (currSum == targetSum && comb.size() == size) {
            list.add(new ArrayList<>(comb));
            return;
        } else if (currSum > targetSum) {
            return;
        } else if (comb.size() == size) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            dfs(list, comb, targetSum, size, i + 1, currSum + i);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 obj = new CombinationSum3();
        int k = 3;
        int n = 7;

        List<List<Integer>> result = obj.combinationSum3(k, n);

        System.out.println("Combinations of " + k + " numbers summing to " + n + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), n, k, 1, 0);
        return list;
    }
}
