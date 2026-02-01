package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PrintSCCs {

    static int id = 0;
    static int[] ids, low;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        int n = 6;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(3);

        ids = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(ids, -1);

        for (int i = 0; i < n; i++)
            if (ids[i] == -1)
                dfs(i);
    }

    static void dfs(int u) {
        ids[u] = low[u] = id++;
        stack.push(u);
        onStack[u] = true;

        for (int v : graph.get(u)) {
            if (ids[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                low[u] = Math.min(low[u], ids[v]);
            }
        }

        if (ids[u] == low[u]) {
            System.out.print("SCC: ");
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                System.out.print(node + " ");
                if (node == u) break;
            }
            System.out.println();
        }
    }
}

