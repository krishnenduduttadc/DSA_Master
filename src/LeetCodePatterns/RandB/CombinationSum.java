package LeetCodePatterns.RandB;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for target 7: " + solver.combinationSum(candidates1, target1));
        // Expected: [[7], [2,2,3]]
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        f(0, target, combination, candidates);
        return answer;
    }

    void f(int i, int rem, List<Integer> combination, int[] candidates) {
        if (i == candidates.length) {
            if (rem == 0) {
                List<Integer> combi = new ArrayList<>();
                for (int num : combination) {
                    combi.add(num);
                }
                answer.add(combi);
            }
        } else {
            int maxTimes = rem / candidates[i];
            for (int k = 0; k <= maxTimes; k++) {
                int newTarget = rem - k * candidates[i];
                for (int j = 0; j < k; j++) {
                    combination.add(candidates[i]);
                }
                f(i + 1, newTarget, combination, candidates);
                for (int j = 0; j < k; j++) {
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }
}
