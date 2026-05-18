package RecursionAndBacktrackingL2;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDiff {

    static int minDiff = Integer.MAX_VALUE;
    static List<Integer> bestSet1 = new ArrayList<>();
    static List<Integer> bestSet2 = new ArrayList<>();

    static void solve(int[] arr, int idx,
                      List<Integer> set1, List<Integer> set2,
                      int sum1, int sum2) {

        if (idx == arr.length) {

            if (Math.abs(sum1 - sum2) < minDiff) {
                minDiff = Math.abs(sum1 - sum2);
                bestSet1 = new ArrayList<>(set1);
                bestSet2 = new ArrayList<>(set2);
            }

            return;
        }

        if (set1.size() < (arr.length + 1) / 2) {
            set1.add(arr[idx]);
            solve(arr, idx + 1, set1, set2, sum1 + arr[idx], sum2);
            set1.remove(set1.size() - 1);
        }

        if (set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[idx]);
            solve(arr, idx + 1, set1, set2, sum1, sum2 + arr[idx]);
            set2.remove(set2.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 2, 4};

        solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);

        System.out.println(minDiff);
        System.out.println(bestSet1);
        System.out.println(bestSet2);
    }
}