package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//Core Idea (simple)
//Find SCCs using Tarjan
//Any SCC with:
//size > 1 ✅ OR
//size == 1 but has a self-loop ✅
//        → forms a cycle

public class FindAllCycles {

    static int id = 0;
    static int[] disc, low;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        int n = 6;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Graph with cycles
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0); // cycle 0-1-2
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(3); // cycle 3-4-5

        disc = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1)
                dfs(i);
        }
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

        // SCC root
        if (disc[u] == low[u]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);
                if (node == u) break;
            }

            if (scc.size() > 1) {
                System.out.println("Cycle found: " + scc);
            }
        }
    }
}

