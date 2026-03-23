package GraphL3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class PrintShortestPath {

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // helper to add undirected weighted edge
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 2, 5, 5);
        addEdge(adj, 2, 3, 4);
        addEdge(adj, 1, 4, 1);
        addEdge(adj, 4, 3, 3);
        addEdge(adj, 3, 5, 1);

        PrintShortestPath obj = new PrintShortestPath();
        List<Integer> path = obj.shortestPath(V, adj);

        for (int x : path) {
            System.out.print(x + " ");
        }
    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    public List<Integer> shortestPath(int n, ArrayList<ArrayList<Pair>> adj) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((x, y) -> x.first - y.first);

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new Pair(0, 1)); // (distance, node)

        while (!pq.isEmpty()) {
            Pair it = pq.poll();

            int dis = it.first;
            int node = it.second;

            // Optional optimization (skip outdated entries)
            if (dis > dist[node]) continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int wt = iter.second;

                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();

        if (dist[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);

        Collections.reverse(path);
        return path;
    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;     // distance OR node (depends on usage)
            this.second = second;
        }
    }
}