package GraphL3;

import java.util.ArrayList;

public class DFS_directed {
    public static void main(String args[]) {
        int V = 5;
        boolean[] vis = new boolean[V + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed edges
        adj.get(1).add(3);
        adj.get(1).add(2);
        adj.get(3).add(4);
        adj.get(4).add(5);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, vis, adj, component);
                res.add(component);
            }
        }

        System.out.println("Connected Components (in Directed Graph):");
        System.out.println(res);
    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> component) {
        vis[node] = true;
        component.add(node);
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj, component);
            }
        }
    }
}
