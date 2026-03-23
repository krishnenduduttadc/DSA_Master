package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;

public class CityWiththeSmallestNumberofNeighbours {

    public static void main(String[] args) {

        int n = 4;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // undirected weighted graph
        addEdge(adj, 0, 1, 3);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 1, 3, 4);
        addEdge(adj, 2, 3, 1);

        int threshold = 4;

        CityWiththeSmallestNumberofNeighbours obj =
                new CityWiththeSmallestNumberofNeighbours();

        int ans = obj.findCity(n, adj, threshold);

        System.out.println("The answer is node: " + ans);
    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    int findCity(int n, ArrayList<ArrayList<Pair>> adj,
                 int distanceThreshold) {

        int[][] dist = new int[n][n];

        // Step 1: initialize
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
            dist[i][i] = 0;
        }

        // Step 2: fill from adjacency list
        for (int u = 0; u < n; u++) {
            for (Pair it : adj.get(u)) {
                int v = it.first;
                int wt = it.second;

                dist[u][v] = wt;
            }
        }

        // Step 3: Floyd Warshall
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] == (int) 1e9 ||
                            dist[via][j] == (int) 1e9) continue;

                    dist[i][j] = Math.min(dist[i][j],
                            dist[i][via] + dist[via][j]);
                }
            }
        }

        // Step 4: find answer
        int minCount = n;
        int cityNo = -1;

        for (int city = 0; city < n; city++) {

            int count = 0;

            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    count++;
                }
            }

            // IMPORTANT: <= for larger index preference
            if (count <= minCount) {
                minCount = count;
                cityNo = city;
            }
        }

        return cityNo;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;     // node
            this.second = second;   // weight
        }
    }
}