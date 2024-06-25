package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberofWaystoArriveatDestination {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        int mod = (int) (1e9 + 7);

        while (pq.size() != 0) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                } else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {
        int n = 7;
        List<List<Integer>> roads = new ArrayList<>() {{
            add(new ArrayList<>(Arrays.asList(0, 6, 7)));
            add(new ArrayList<>(Arrays.asList(0, 1, 2)));
            add(new ArrayList<>(Arrays.asList(1, 2, 3)));
            add(new ArrayList<>(Arrays.asList(1, 3, 3)));
            add(new ArrayList<>(Arrays.asList(6, 3, 3)));
            add(new ArrayList<>(Arrays.asList(3, 5, 1)));
            add(new ArrayList<>(Arrays.asList(6, 5, 1)));
            add(new ArrayList<>(Arrays.asList(2, 5, 1)));
            add(new ArrayList<>(Arrays.asList(0, 4, 5)));
            add(new ArrayList<>(Arrays.asList(4, 6, 2)));
        }};
        NumberofWaystoArriveatDestination obj = new NumberofWaystoArriveatDestination();
        int ans = obj.countPaths(n, roads);

        System.out.print(ans);
        System.out.println();
    }
}
