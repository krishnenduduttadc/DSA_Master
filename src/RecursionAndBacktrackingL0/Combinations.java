package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void dfs(List<List<Integer>> list, List<Integer> comb, int n, int k, int start) {
        if (comb.size() == k) {
            list.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            dfs(list, comb, n, k, i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        int n = 4;
        int k = 2;
        List<List<Integer>> result = obj.combine(n, k);

        System.out.println("Combinations of " + k + " numbers from 1 to " + n + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), n, k, 1);
        return list;
    }
}
