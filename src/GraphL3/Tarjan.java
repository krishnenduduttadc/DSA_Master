package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tarjan {
    private int timer = 1;

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2},
                {2, 0}, {1, 3}
        };

        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            connections.add(Arrays.asList(edges[i][0], edges[i][1]));
        }

        Tarjan obj = new Tarjan();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);

        for (List<Integer> bridge : bridges) {
            System.out.println("[" + bridge.get(0) + ", " + bridge.get(1) + "]");
        }
    }

    private void dfs(int node, int parent, int[] vis,
                     ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low,
                     List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;

            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                // Bridge condition
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(node, it));
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges;
    }
}
