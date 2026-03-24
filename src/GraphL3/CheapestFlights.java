package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights {

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;

        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };

        CheapestFlights obj = new CheapestFlights();
        int ans = obj.findCheapestFlight(n, flights, src, dst, K);

        System.out.println(ans);
    }

    // -------- MAIN FUNCTION --------
    public int findCheapestFlight(int n, int[][] flights, int src, int dst, int K) {

        // Step 1: Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights) {
            int u = f[0], v = f[1], wt = f[2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 2: Queue -> (stops, node, cost)
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));

        // Step 3: Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // Step 4: BFS traversal
        while (!q.isEmpty()) {
            Tuple curr = q.poll();

            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;

            if (stops > K) continue;

            for (Pair edge : adj.get(node)) {
                int nextNode = edge.node;
                int weight = edge.weight;

                if (cost + weight < dist[nextNode] && stops <= K) {
                    dist[nextNode] = cost + weight;
                    q.offer(new Tuple(stops + 1, nextNode, dist[nextNode]));
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }

    // -------- HELPER CLASSES --------
    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Tuple {
        int stops, node, cost;

        Tuple(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }
}