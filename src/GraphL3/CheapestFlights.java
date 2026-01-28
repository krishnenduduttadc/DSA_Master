package GraphL3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class CheapestFlights {
    public static void main(String[] args) {

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        CheapestFlights obj = new CheapestFlights();
        int ans = obj.CheapestFlight(n, flights, src, dst, K);

        System.out.print(ans);
        System.out.println();
    }

    public int CheapestFlight(int n, int flights[][], int src, int dst, int K) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple2> q = new LinkedList<>();
        q.add(new Tuple2(0, src, 0));
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            Tuple2 it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;
            if (stops > K) continue;
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;
                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple2(stops + 1, adjNode, cost + edW));
                }
            }
        }
        if (dist[dst] == (int) (1e9)) return -1;
        return dist[dst];
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple2 {
        int first, second, third;

        public Tuple2(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
