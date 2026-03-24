package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;


public class BellmanFord {
    public static void main(String[] args) {
        int V = 6;
        int s = 0;

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add edges (u -> v, wt)
        adj.get(3).add(new Pair(2, 6));
        adj.get(5).add(new Pair(3, 1));
        adj.get(0).add(new Pair(1, 5));
        adj.get(1).add(new Pair(5, -3));
        adj.get(1).add(new Pair(2, -2));
        adj.get(3).add(new Pair(4, -2));
        adj.get(2).add(new Pair(4, 3));

        int[] dist = bellman_ford(V, adj, s);

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    static int[] bellman_ford(int n,
                              ArrayList<ArrayList<Pair>> adj, int s) {

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e8);
        dist[s] = 0;

        // Relax edges n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (Pair p : adj.get(u)) {
                    int v = p.v;
                    int wt = p.wt;

                    if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Check negative cycle
        for (int u = 0; u < n; u++) {
            for (Pair p : adj.get(u)) {
                int v = p.v;
                int wt = p.wt;

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    return new int[]{-1};
                }
            }
        }

        return dist;
    }

    static class Pair {
        int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }
}