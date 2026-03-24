package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberofWaystoArriveatDestination {

    public static void main(String[] args) {

        int n = 7;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 6, 7);
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 3);
        addEdge(adj, 6, 3, 3);
        addEdge(adj, 3, 5, 1);
        addEdge(adj, 6, 5, 1);
        addEdge(adj, 2, 5, 1);
        addEdge(adj, 0, 4, 5);
        addEdge(adj, 4, 6, 2);

        NumberofWaystoArriveatDestination obj =
                new NumberofWaystoArriveatDestination();

        int ans = obj.countPaths(n, adj);

        System.out.println(ans);
    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj,
                        int u, int v, int w) {

        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    public int countPaths(int n, ArrayList<ArrayList<Pair>> adj) {

        PriorityQueue<NodePair> pq =
                new PriorityQueue<>((x, y) -> x.dist - y.dist);

        int[] dist = new int[n];
        int[] ways = new int[n];

        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new NodePair(0, 0));

        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {

            NodePair it = pq.poll();
            int node = it.node;
            int dis = it.dist;

            // skip outdated entries
            if (dis > dist[node]) continue;

            for (Pair neigh : adj.get(node)) {

                int adjNode = neigh.node;
                int wt = neigh.weight;

                // shorter path found
                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    pq.add(new NodePair(dist[adjNode], adjNode));

                    ways[adjNode] = ways[node]; // inherit ways
                }
                // another shortest path found
                else if (dis + wt == dist[adjNode]) {
                    ways[adjNode] =
                            (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }

    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class NodePair {
        int dist, node;

        NodePair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
}