package GraphL3;

import java.util.ArrayList;

class DFS {

    public static void main(String args[]) {
        int V = 5;
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected Graph
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, vis, adj, component);
                res.add(component);
            }
        }

        System.out.println("Connected Components: " + res);
    }

    public static void dfs(int s, boolean[] vis, ArrayList<ArrayList<Integer>> adj,
                           ArrayList<Integer> component) {
        vis[s] = true;
        component.add(s);
        for (int it : adj.get(s)) {
            if (!vis[it]) {
                dfs(it, vis, adj, component);
            }
        }
    }
}
