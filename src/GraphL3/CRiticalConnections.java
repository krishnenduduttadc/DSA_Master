package GraphL3;

import java.util.ArrayList;
import java.util.List;

public class CRiticalConnections {
    boolean[] vis;
    int[] disc;
    int[] low;
    int time = 0;

    public static void main(String[] args) {
        CRiticalConnections solution = new CRiticalConnections();

        int n = 5;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(List.of(0, 1));
        connections.add(List.of(0, 2));
        connections.add(List.of(1, 2));
        connections.add(List.of(2, 3));
        connections.add(List.of(3, 4));

        List<List<Integer>> criticalConnections = solution.criticalConnections(n, connections);

        System.out.println("Critical Connections (Bridges):");
        for (List<Integer> connection : criticalConnections) {
            System.out.println(connection.get(0) + " - " + connection.get(1));
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        // Step 1: Build the graph (adjacency list)
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: Initialize arrays
        vis = new boolean[n];
        disc = new int[n];
        low = new int[n];

        // Step 3: Run DFS for all components (handle disconnected graph too)
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true; // ✅ FIX: Mark the node as visited before DFS
                bridges(graph, n, i, -1, ans);
            }
        }

        return ans;
    }

    private void bridges(List<List<Integer>> graph, int n, int src, int par, List<List<Integer>> ans) {
        disc[src] = time;
        low[src] = time;
        time++;

        for (int nbr : graph.get(src)) {
            if (nbr == par) continue;

            if (!vis[nbr]) {
                vis[nbr] = true;
                bridges(graph, n, nbr, src, ans);
                low[src] = Math.min(low[src], low[nbr]);

                // Bridge condition
                if (low[nbr] > disc[src]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(src);
                    bridge.add(nbr);
                    ans.add(bridge);
                }
            } else {
                low[src] = Math.min(low[src], disc[nbr]); // back edge
            }
        }
    }
}
