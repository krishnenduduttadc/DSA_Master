package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Idea
//Find SCCs
//Build condensed DAG
//Count:
//SCCs with 0 in-degree
//SCCs with 0 out-degree
//        Answer = max(inZero, outZero)
public class MinEdgesToStronglyConnect {

    static int id = 0, sccCount = 0;
    static int[] disc, low, sccId;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        int n = 4;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);

        disc = new int[n];
        low = new int[n];
        sccId = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++)
            if (disc[i] == -1)
                dfs(i);

        int[] in = new int[sccCount];
        int[] out = new int[sccCount];

        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                if (sccId[u] != sccId[v]) {
                    out[sccId[u]]++;
                    in[sccId[v]]++;
                }
            }
        }

        int inZero = 0, outZero = 0;
        for (int i = 0; i < sccCount; i++) {
            if (in[i] == 0) inZero++;
            if (out[i] == 0) outZero++;
        }

        System.out.println("Min edges needed = " +
                (sccCount == 1 ? 0 : Math.max(inZero, outZero)));
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
                sccId[node] = sccCount;
                if (node == u) break;
            }
            sccCount++;
        }
    }
}
