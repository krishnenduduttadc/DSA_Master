package GraphL5;


import java.util.ArrayList;
import java.util.Arrays;


public class BellmanFordPatterns {
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

        System.out.println("Shortest Distances:");
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }

        System.out.println("\nHas Negative Cycle: " + hasNegativeCycle(V, adj, s));

        System.out.println("Shortest Path (0 -> 4): " +
                getShortestPath(V, adj, s, 4));

        System.out.println("Successful Relaxations: " +
                countRelaxations(V, adj, s));
        System.out.println("Network Delay Time: " +
                networkDelayBellmanFord(V, adj, s));

        System.out.println("Cheapest Price (0 -> 4, K = 2): " +
                findCheapestPriceKStops(V, adj, 0, 4, 2));
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

    static boolean hasNegativeCycle(int n,
                                    ArrayList<ArrayList<Pair>> adj,
                                    int s) {
        final int INF = (int) 1e8;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        // Relax all edges (V-1) times
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (Pair p : adj.get(u)) {
                    int v = p.v;
                    int wt = p.wt;
                    if (dist[u] != INF && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        // One more relaxation => Negative Cycle exists
        for (int u = 0; u < n; u++) {
            for (Pair p : adj.get(u)) {

                int v = p.v;
                int wt = p.wt;

                if (dist[u] != INF && dist[u] + wt < dist[v]) {
                    return true;
                }
            }
        }
        return false;
    }

    static ArrayList<Integer> getShortestPath(int n,
                                              ArrayList<ArrayList<Pair>> adj,
                                              int src,
                                              int dest) {
        final int INF = (int) 1e8;
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, INF);
        for (int i = 0; i < n; i++)
            parent[i] = i;

        dist[src] = 0;
        // Relax edges V-1 times
        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int u = 0; u < n; u++) {
                for (Pair p : adj.get(u)) {
                    int v = p.v;
                    int wt = p.wt;
                    if (dist[u] != INF &&
                            dist[u] + wt < dist[v]) {

                        dist[v] = dist[u] + wt;
                        parent[v] = u;
                        updated = true;
                    }
                }
            }
            if (!updated)
                break;
        }

        // Check for reachable negative cycle
        for (int u = 0; u < n; u++) {
            for (Pair p : adj.get(u)) {
                int v = p.v;
                int wt = p.wt;
                if (dist[u] != INF &&
                        dist[u] + wt < dist[v]) {
                    return new ArrayList<>(); // Path undefined
                }
            }
        }
        // Destination unreachable
        if (dist[dest] == INF)
            return new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int node = dest;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        java.util.Collections.reverse(path);
        return path;
    }

    static int countRelaxations(int n,
                                ArrayList<ArrayList<Pair>> adj,
                                int s) {
        final int INF = (int) 1e8;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        int relaxations = 0;
        // Relax edges V-1 times
        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int u = 0; u < n; u++) {
                for (Pair p : adj.get(u)) {
                    int v = p.v;
                    int wt = p.wt;
                    if (dist[u] != INF &&
                            dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        relaxations++;
                        updated = true;
                    }
                }
            }
            // No updates => shortest paths finalized
            if (!updated)
                break;
        }
        return relaxations;
    }

    static int networkDelayBellmanFord(int n,
                                       ArrayList<ArrayList<Pair>> adj,
                                       int src) {
        final int INF = (int) 1e8;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        // Relax all edges V-1 times
        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int u = 0; u < n; u++) {
                for (Pair p : adj.get(u)) {
                    int v = p.v;
                    int wt = p.wt;
                    if (dist[u] != INF &&
                            dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        updated = true;
                    }
                }
            }
            if (!updated)
                break;
        }
        // If any node is unreachable
        int maxTime = 0;
        for (int d : dist) {
            if (d == INF)
                return -1;
            maxTime = Math.max(maxTime, d);
        }
        return maxTime;
    }

    static int findCheapestPriceKStops(int n,
                                       ArrayList<ArrayList<Pair>> adj,
                                       int src,
                                       int dst,
                                       int k) {
        final int INF = (int) 1e8;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        // Relax edges at most (k + 1) times
        // because k stops = k+1 edges
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for (int u = 0; u < n; u++) {
                if (dist[u] == INF)
                    continue;
                for (Pair p : adj.get(u)) {
                    int v = p.v;
                    int wt = p.wt;
                    if (dist[u] + wt < temp[v]) {
                        temp[v] = dist[u] + wt;
                    }
                }
            }
            dist = temp;
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }

    static class Pair {
        int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }
}
