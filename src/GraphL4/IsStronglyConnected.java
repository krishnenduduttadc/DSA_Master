package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class IsStronglyConnected {

    static int id = 0, sccCount = 0;
    static int[] ids, low;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static List<List<Integer>> adj;

    public static void main(String[] args) {
        int n = 4;

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);

        ids = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(ids, -1);

        for (int i = 0; i < n; i++)
            if (ids[i] == -1)
                dfs(i);

        System.out.println("Strongly Connected? " + (sccCount == 1));
    }

    static void dfs(int u) {
        ids[u] = low[u] = id++;
        stack.push(u);
        onStack[u] = true;
        for (int it : adj.get(u)) {
            if (ids[it] == -1) {
                dfs(it);
                low[u] = Math.min(low[u], low[it]);
            } else if (onStack[it]) {
                low[u] = Math.min(low[u], low[it]);
            }
        }

        if (ids[u] == low[u]) {
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                if (node == u) {
                    break;
                }
            }
            sccCount++;
        }
    }
}
