package CodingShuttle.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1};
        int sum = 2;
        Arrays.sort(a);

        ArrayList<ArrayList<Integer>> ans = combinationSum(a, sum);

        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] a, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helperCombinationSum(a, ans, 0, sum, new ArrayList<>());
        return ans;
    }

    private static void helperCombinationSum(int[] a, ArrayList<ArrayList<Integer>> ans,
                                             int index, int sum, ArrayList<Integer> cur) {

        if (sum == 0) {
            ans.add(new ArrayList<>(cur)); // Add a copy of the current combination
            return;
        }

        for (int i = index; i < a.length; i++) {
            if (a[i] > sum) return;
            if (i > index && a[i] == a[i - 1]) continue; // Skip duplicates

            cur.add(a[i]);
            helperCombinationSum(a, ans, i + 1, sum - a[i], cur); // Recursive call
            cur.remove(cur.size() - 1); // Backtrack
        }
    }
}
