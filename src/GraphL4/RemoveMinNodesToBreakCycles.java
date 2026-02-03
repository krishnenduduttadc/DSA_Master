package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//
//Observation:
//Every cycle lies inside an SCC
//Removing 1 node per SCC (size > 1) breaks all cycles
//Minimum removals = number of SCCs with size > 1

public class RemoveMinNodesToBreakCycles {

    static int id = 0;
    static int[] disc, low;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static List<List<Integer>> graph;
    static int removeCount = 0;

    public static void main(String[] args) {
        int n = 6;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0); // cycle
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(3); // cycle

        disc = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++)
            if (disc[i] == -1)
                dfs(i);

        System.out.println("Minimum nodes to remove = " + removeCount);
    }

    static void dfs(int u) {
        disc[u] = low[u] = id++;
        stack.push(u);
        onStack[u] = true;

        for (int v : graph.get(u)) {
            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (disc[u] == low[u]) {
            int size = 0;
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                size++;
                if (node == u) break;
            }

            if (size > 1) {
                removeCount++; // remove one node from this SCC
            }
        }
    }
}

