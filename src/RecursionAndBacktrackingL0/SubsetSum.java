package RecursionAndBacktrackingL0;

import java.util.ArrayList;

public class SubsetSum {

    public static void dfs(ArrayList<Integer> arr, ArrayList<Integer> list, int sum, int index) {
        if (index == arr.size()) {
            list.add(sum);
            return;
        }
        dfs(arr, list, sum + arr.get(index), index + 1);
        dfs(arr, list, sum, index + 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);


        ArrayList<Integer> ret = subsetSums(arr, 2);
        System.out.println(ret);
    }

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(arr, list, 0, 0);
        return list;
    }
}
