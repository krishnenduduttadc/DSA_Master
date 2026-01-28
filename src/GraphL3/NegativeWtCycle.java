package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NegativeWtCycle {
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] ans = new int[v];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair rem = pq.remove();

            if (ans[rem.vtx] != Integer.MAX_VALUE) continue;
            ans[rem.vtx] = rem.wsf;
            for (ArrayList<Integer> edge : adj.get(rem.vtx)) {
                int nbr = edge.get(0);
                int wt = edge.get(1);
                if (ans[nbr] == Integer.MAX_VALUE) {
                    pq.add(new Pair(nbr, rem.wsf + wt));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2))); // Edge from vertex 0 to vertex 1 with weight 2
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4))); // Edge from vertex 0 to vertex 2 with weight 4
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1))); // Edge from vertex 1 to vertex 2 with weight 1
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7))); // Edge from vertex 1 to vertex 3 with weight 7
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 3))); // Edge from vertex 2 to vertex 3 with weight 3
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 2))); // Edge from vertex 3 to vertex 4 with weight 2
        adj.get(4).add(new ArrayList<>(Arrays.asList(5, 5))); // Edge from vertex 4 to vertex 5 with weight 5
        int sourceVertex = 0;
        int[] shortestDistances = dijkstra(V, adj, sourceVertex);
        System.out.println("Shortest distances from vertex " + sourceVertex + ": ");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + shortestDistances[i]);
        }
    }

    public static class Pair implements Comparable<Pair> {
        int vtx, wsf;

        Pair(int vtx, int wsf) {
            this.vtx = vtx;
            this.wsf = wsf;
        }

        public int compareTo(Pair other) {
            return this.wsf - other.wsf;
        }
    }
}
