package GraphL3;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Prim {

    static int spanningTree(int v, ArrayList<ArrayList<Pair>> adj) {

        PriorityQueue<NodePair> pq =
                new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int[] vis = new int[v];
        pq.add(new NodePair(0, 0)); // (weight, node)
        int sum = 0;
        while (!pq.isEmpty()) {
            NodePair it = pq.poll();
            int node = it.node;
            int wt = it.dist;
            if (vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            for (Pair neigh : adj.get(node)) {
                int adjNode = neigh.node;
                int edgeWt = neigh.weight;
                if (vis[adjNode] == 0) {
                    pq.add(new NodePair(edgeWt, adjNode));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 1);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 2, 3, 2);
        addEdge(adj, 3, 4, 1);
        addEdge(adj, 4, 2, 2);
        int sum = spanningTree(V, adj);
        System.out.println("MST weight: " + sum);
    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
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