package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinUndirectedGraphUnitWeights {

    public static void main(String[] args) {
        int n = 9;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 6);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 8);
        addEdge(adj, 6, 8);

        ShortestPathinUndirectedGraphUnitWeights obj =
                new ShortestPathinUndirectedGraphUnitWeights();
        int[] res = obj.shortestPath(n, adj, 0);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    // helper to add undirected edge
    static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v) {
        adj.get(u).add(new Pair(v, 1));
        adj.get(v).add(new Pair(u, 1));
    }

    public int[] shortestPath(int n, ArrayList<ArrayList<Pair>> adj, int s) {

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        Queue<Integer> q = new LinkedList<>();
        dist[s] = 0;
        q.add(s);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair it : adj.get(node)) {
                int v = it.first;
                int wt = it.second; // always 1
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                    q.add(v);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;     // node
            this.second = second;   // weight (will be 1 here)
        }
    }
}