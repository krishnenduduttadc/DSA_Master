package GraphL1;

import java.util.ArrayList;

public class BackEdge {
    static int V = 7;
    static int[] visited = new int[V + 1];

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3); // back edge
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 4); // back edge

        System.out.println("DFS Traversal and Back Edge Detection:");
        DFS(adj, V);
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                DFSR(adj, i, -1);
            }
        }
    }

    private static void DFSR(ArrayList<ArrayList<Integer>> adj, int node, int parent) {
        System.out.println("Visited node: " + node);
        visited[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                DFSR(adj, neighbor, node);
            } else if (neighbor != parent) {
                System.out.println("Back edge detected: " + node + " -> " + neighbor);
            }
        }
    }
}
