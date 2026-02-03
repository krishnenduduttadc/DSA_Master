package GraphL3;

import java.util.ArrayList;
import java.util.List;

public class DFSEdgeTypes {

    static List<List<Integer>> adj;
    static int[] disc, finish;
    static int time;

    static void dfs(int u) {
        disc[u] = ++time;

        for (int v : adj.get(u)) {
            if (disc[v] == 0) {
                // Tree edge
                System.out.println("Tree Edge: " + u + " -> " + v);
                dfs(v);
            } else if (finish[v] == 0) {
                // Back edge (to ancestor)
                System.out.println("Back Edge: " + u + " -> " + v);
            } else if (disc[u] < disc[v]) {
                // Forward edge (to descendant, not tree edge)
                System.out.println("Forward Edge: " + u + " -> " + v);
            } else {
                // Cross edge
                System.out.println("Cross Edge: " + u + " -> " + v);
            }
        }

        finish[u] = ++time;
    }

    public static void main(String[] args) {
        int V = 6;

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(3).add(1); // back edge (cycle)
        adj.get(2).add(3); // cross edge
        adj.get(1).add(4);
        adj.get(4).add(5); // forward edge possible

        disc = new int[V];
        finish = new int[V];
        time = 0;

        // Run DFS for all components
        for (int i = 0; i < V; i++) {
            if (disc[i] == 0) {
                dfs(i);
            }
        }
    }
}
