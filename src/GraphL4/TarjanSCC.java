package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//Each time I find a root node in Tarjan, I increment SCC count.

public class TarjanSCC {
    static int id = 0;
    static int sccCount = 0;
    static int[] ids, low;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        int n = 6;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Hardcoded graph
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(3);

        ids = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(ids, -1); // unvisited

        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) {
                dfs(i);
            }
        }

        System.out.println("Total SCCs: " + sccCount);
    }

    static void dfs(int u) {
        ids[u] = low[u] = id++;
        stack.push(u);
        onStack[u] = true;
        for (int it : graph.get(u)) {
            if (ids[it] == -1) {
                dfs(it);
                low[u] = Math.min(low[u], low[it]);
            } else if (onStack[it]) {
                low[u] = Math.min(low[u], ids[it]);
            }
        }

        if (ids[u] == low[u]) {
            System.out.println("SCC");
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                System.out.println(node + " ");
                if (node == u) {
                    break;
                }
            }
            System.out.println();
            sccCount++;
        }
    }


}
