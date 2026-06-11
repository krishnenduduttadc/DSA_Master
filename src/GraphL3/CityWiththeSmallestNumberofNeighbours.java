package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;

public class CityWiththeSmallestNumberofNeighbours {

    static void addEdge(ArrayList<ArrayList<Edge>> adj,
                        int u, int v, int w) {

        adj.get(u).add(new Edge(v, w));
        adj.get(v).add(new Edge(u, w));
    }

    public static void main(String[] args) {

        int n = 4;

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Hardcoded graph
        addEdge(adj, 0, 1, 3);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 1, 3, 4);
        addEdge(adj, 2, 3, 1);

        int threshold = 4;

        CityWiththeSmallestNumberofNeighbours obj =
                new CityWiththeSmallestNumberofNeighbours();

        int city = obj.findCity(n, adj, threshold);

        System.out.println("City with smallest number of neighbours = " + city);
    }

    public int findCity(int n,
                        ArrayList<ArrayList<Edge>> adj,
                        int threshold) {

        int INF = (int) 1e9;
        int[][] dist = new int[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Fill direct edges
        for (int u = 0; u < n; u++) {
            for (Edge edge : adj.get(u)) {
                dist[u][edge.to] = edge.weight;
            }
        }

        // Floyd-Warshall
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] == INF ||
                            dist[via][j] == INF)
                        continue;

                    dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][via] + dist[via][j]
                    );
                }
            }
        }

        // Find city with minimum reachable neighbors
        int answer = -1;
        int minReachable = n;

        for (int city = 0; city < n; city++) {

            int reachable = 0;

            for (int next = 0; next < n; next++) {
                if (dist[city][next] <= threshold)
                    reachable++;
            }

            // Choose larger index in case of tie
            if (reachable <= minReachable) {
                minReachable = reachable;
                answer = city;
            }
        }

        return answer;
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}