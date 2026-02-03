package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class IsStronglyConnected {

    static int id = 0, sccCount = 0;
    static int[] disc, low;
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

        disc = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++)
            if (disc[i] == -1)
                dfs(i);

        System.out.println("Strongly Connected? " + (sccCount == 1));
    }

    static void dfs(int u) {
        disc[u] = low[u] = id++;
        stack.push(u);
        onStack[u] = true;
        for (int it : adj.get(u)) {
            if (disc[it] == -1) {
                dfs(it);
                low[u] = Math.min(low[u], low[it]);
            } else if (onStack[it]) {
                low[u] = Math.min(low[u], disc[it]);
            }
        }

        if (disc[u] == low[u]) {
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
