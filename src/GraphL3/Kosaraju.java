package GraphL3;

import java.util.ArrayList;
import java.util.Stack;

class Kosaraju {
    // Main method for testing the Kosaraju algorithm.
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        Kosaraju obj = new Kosaraju();
        int ans = obj.kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }

    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    private void dfsTranspose(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfsTranspose(it, vis, adjT);
            }
        }
    }

    // Function to find the number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();

        // Step 1: Perform DFS and fill the stack.
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // Step 2: Create the transposed graph.
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i)) {
                // i -> it in the original graph, so it -> i in the transposed graph.
                adjT.get(it).add(i);
            }
        }

        // Step 3: Count SCCs using DFS on the transposed graph.
        int sccCount = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                sccCount++;
                dfsTranspose(node, vis, adjT);
            }
        }

        return sccCount;
    }
}