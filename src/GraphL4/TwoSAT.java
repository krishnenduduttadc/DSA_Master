package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//Idea
//Each variable → node
//Build implication graph
//If x and ¬x are in same SCC → ❌ impossible

public class TwoSAT {

    static int id = 0;
    static int[] disc, low;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        int vars = 2; // x1, x2
        int n = vars * 2;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // (x1 OR x2)
        addImplication(0 ^ 1, 2); // !x1 -> x2
        addImplication(2 ^ 1, 0); // !x2 -> x1

        disc = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++)
            if (disc[i] == -1)
                dfs(i);

        for (int i = 0; i < vars; i++) {
            if (disc[2 * i] == disc[2 * i + 1]) {
                System.out.println("Unsatisfiable");
                return;
            }
        }
        System.out.println("Satisfiable");
    }

    static void addImplication(int u, int v) {
        graph.get(u).add(v);
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
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                if (node == u) break;
            }
        }
    }
}

