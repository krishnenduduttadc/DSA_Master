package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NegativeWtCycle {
    public static class Pair implements Comparable<Pair>{
        int vtx, wsf;

        Pair(int vtx, int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }

        public int compareTo(Pair other){
            return this.wsf - other.wsf;
        }
    }

    // Function to find the shortest distance of all vertices from source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start with the source vertex S with weight 0.
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair rem = pq.remove();

            // If we have already processed this vertex, continue.
            if (ans[rem.vtx] != Integer.MAX_VALUE) continue;

            // Update the shortest distance to this vertex.
            ans[rem.vtx] = rem.wsf;

            // Traverse all neighboring vertices.
            for (ArrayList<Integer> edge : adj.get(rem.vtx)) {
                int nbr = edge.get(0);
                int wt = edge.get(1);

                // If the neighboring vertex has not been visited, add it to the priority queue.
                if (ans[nbr] == Integer.MAX_VALUE) {
                    pq.add(new Pair(nbr, rem.wsf + wt));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example graph representation using adjacency list

        // Number of vertices
        int V = 6;

        // Adjacency list representation of the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2))); // Edge from vertex 0 to vertex 1 with weight 2
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4))); // Edge from vertex 0 to vertex 2 with weight 4
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1))); // Edge from vertex 1 to vertex 2 with weight 1
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7))); // Edge from vertex 1 to vertex 3 with weight 7
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 3))); // Edge from vertex 2 to vertex 3 with weight 3
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 2))); // Edge from vertex 3 to vertex 4 with weight 2
        adj.get(4).add(new ArrayList<>(Arrays.asList(5, 5))); // Edge from vertex 4 to vertex 5 with weight 5

        // Source vertex for Dijkstra's algorithm
        int sourceVertex = 0;

        // Call Dijkstra's algorithm to find shortest paths from sourceVertex
        int[] shortestDistances = dijkstra(V, adj, sourceVertex);

        // Print the shortest distances from the source vertex
        System.out.println("Shortest distances from vertex " + sourceVertex + ": ");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + shortestDistances[i]);
        }
    }
}
