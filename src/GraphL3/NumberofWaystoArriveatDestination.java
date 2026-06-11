package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberofWaystoArriveatDestination {

    static void addEdge(ArrayList<ArrayList<Edge>> adj,
                        int u, int v, int w) {

        adj.get(u).add(new Edge(v, w));
        adj.get(v).add(new Edge(u, w));
    }

    public static void main(String[] args) {

        int n = 7;

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Hardcoded graph
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

        System.out.println("Number of shortest paths = " + ans);
    }

    public int countPaths(int n, ArrayList<ArrayList<Edge>> adj) {

        int MOD = 1_000_000_007;

        int[] dist = new int[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            int node = curr.vertex;
            int distance = curr.dist;

            if (distance > dist[node])
                continue;

            for (Edge edge : adj.get(node)) {

                int nextNode = edge.to;
                int newDist = distance + edge.weight;

                if (newDist < dist[nextNode]) {

                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];

                    pq.offer(new Node(nextNode, newDist));
                } else if (newDist == dist[nextNode]) {

                    ways[nextNode] =
                            (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int vertex, dist;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }
}