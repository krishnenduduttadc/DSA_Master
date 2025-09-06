package LeetCodePatterns.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int N = 4;
        int K = 2;

        NetworkDelay solution = new NetworkDelay();
        int result = solution.networkDelayTime(times, N, K);

        System.out.println("Network Delay Time: " + result);
    }

    public int[] computeDistance(List<List<Pair<Integer, Integer>>> graph, int k) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        pq.offer(new Pair<>(k, 0));

        while (!pq.isEmpty()) {
            int currentDistance = pq.peek().getValue();
            int top = pq.peek().getKey();
            pq.poll();

            if (dist[top] > currentDistance) {
                dist[top] = currentDistance;

                for (Pair<Integer, Integer> edge : graph.get(top)) {
                    int v = edge.getKey();
                    int w = edge.getValue();
                    if (dist[v] > currentDistance + w) {
                        pq.offer(new Pair<>(v, currentDistance + w));
                    }
                }
            }
        }

        return dist;
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
            graph.get(u).add(new Pair<>(v, w));
        }

        int[] distance = computeDistance(graph, K - 1);
        int maxDist = Arrays.stream(distance).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
