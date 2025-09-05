package LeetCodePatterns.RandB;

import java.util.*;

public class CombinationsSum2 {

    public static void main(String[] args) {
        CombinationsSum2 solver = new CombinationsSum2();
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println("Combinations for target=8: " + solver.combinationSum2(candidates1, target1));
        // Expected: [[1,1,6], [1,2,5], [1,7], [2,6]]
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> combinations = new HashSet<>();

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : candidates) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        List<Integer> uniq = new ArrayList<>();
        for (int num : freq.keySet()) {
            uniq.add(num);
        }
        Collections.sort(uniq);

        backtrack(combinations, new ArrayList<>(), freq, uniq, target, 0);

        return new ArrayList<>(combinations);
    }

    public void backtrack(Set<List<Integer>> combinations, List<Integer> currentSubset, Map<Integer, Integer> freq, List<Integer> uniqueCandidates, int remainingTarget, int i) {

        if (i == uniqueCandidates.size()) {
            if (remainingTarget == 0) {
                combinations.add(new ArrayList<>(currentSubset));
            }
        } else {
            int count = freq.get(uniqueCandidates.get(i));
            for (int j = 0; j <= count && remainingTarget >= uniqueCandidates.get(i) * j; j++) {
                for (int k = 1; k <= j; k++) {
                    currentSubset.add(uniqueCandidates.get(i));
                }
                backtrack(combinations, currentSubset, freq, uniqueCandidates, remainingTarget - uniqueCandidates.get(i) * j, i + 1);

                for (int k = 1; k <= j; k++) {
                    currentSubset.remove(currentSubset.size() - 1);
                }
            }
        }
    }
}
